package com.cfw.m1212.server.movie.service;

import com.cfw.m1212.api.DescriptionService;
import com.cfw.m1212.api.MovieService;
import com.cfw.m1212.model.Description;
import com.cfw.m1212.model.Movie;
import com.cfw.m1212.server.movie.dao.MovieDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {
    private Log logger = LogFactory.getLog(MovieServiceImpl.class);
	
	@Autowired
	private MovieDao movieDaoImpl;

	@Autowired
	private DescriptionService remoteDescriptionService;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:36:06
	 */
	@Override
	public boolean addMovie(Movie movies) {
		
		// Movie's abstract persist succeed then persist the movie.
		try{
            return movieDaoImpl.insertMovie(movies) > 0;
        }catch (Exception e){
		    this.logger.error(e.getMessage(),e);
        }

        return false;
	}

	/**
	 * @param flag <br>
	 * 	Use flag to identify the different usage
	 * of this method.<br>
	 * 	1: Get movie list for management page in table.<br>
	 * 	In this case, we just need id, name, type, score of
	 * movie.<br>
	 *  2: Get movie list for visitors, in index page and
	 *  search page and others.<br>
	 *  We need to get full information of movies.
     * @return
     */
	public List<Movie> getMovies(String keyWord,int start, int length, int flag) {
		List<Movie> movies = null;

		Map<String,Object> paramMap = new HashMap<String,Object>();

		paramMap.put("keyWord",keyWord);
		paramMap.put("start",start);
		paramMap.put("length",length);

        switch(flag){
            case 1:
                movies = movieDaoImpl.selectMovies(paramMap);
                break;
            case 2:
                movies = movieDaoImpl.selectFullMovies(paramMap);
                break;
        }

		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:58:14
	 */
	@Override
	public int countMovies() {
        return movieDaoImpl.selectCount();
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:28:07
	 */
	@Override
	public Movie getOneMovie(int id) {
        return this.movieDaoImpl.selectOne(id);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:18
	 */
	@Override
	public List<Movie> findPic(int start, int length) {
        return this.movieDaoImpl.selectPic(start, length);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:21
	 */
	@Override
	public boolean  modifyPic(String pic, int movieId) {
		return this.movieDaoImpl.updatePic(pic,movieId) > 0;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:08:14
	 */
	@Override
	public boolean deleteMovie(int... mids) {
		for(int mid : mids){
			Movie movie = new Movie();
			movie.setId(mid);
			movie.setDeleted(true);
			
			int deleteResult = this.movieDaoImpl.updateMovie(movie);
			if(deleteResult <= 0) return false;
		}
		
		return true;
	}


	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午4:52:32
	 */
	@Override
	public Boolean modifyMoive(Movie movie) {
		
		if(movie.getId()<=0) return false;
		
		try{
			int descriptionId = this.movieDaoImpl.selectDesciptionId(movie.getId());
			if(descriptionId <=0 ) return false;

			Description description = movie.getDescription();
			description.setId(descriptionId);

			if(!this.remoteDescriptionService.modifyDescription(description)) return false;

			int updateMovieResult = this.movieDaoImpl.updateMovie(movie);

			if(updateMovieResult > 0) return true;
		}catch (Exception e){
			this.logger.error(e.getMessage(),e);
		}
		
		return false;
	}
}

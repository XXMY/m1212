package com.cfw.m1212.web.home.service;

import com.cfw.m1212.api.MovieService;
import com.cfw.m1212.model.Movie;
import com.cfw.m1212.model.Type;
import com.cfw.m1212.web.commons.dto.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service
public class HomeMovieService {
	private Log logger = LogFactory.getLog(HomeMovieService.class);

	@Autowired
	private MovieService remoteMovieService;

	@Autowired
	private HomeTypeService typeService;

	@Autowired
	private HomeDescriptionService descriptionService;

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:36:06
	 */
	public boolean addMovie(Movie movie) {
		// Persist movie's abstract first.
		boolean addAbstractResult = this.descriptionService.addDescription(movie.getDescription());

		// Movie's abstract persist succeed then persist the movie.
		if(addAbstractResult){
			return this.remoteMovieService.addMovie(movie);
		}

		return false;
	}

	/**
	 *
	 * @param page<Page>
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
	public List<Movie> getMovies(Page page, int flag) {
		List<Movie> movies = this.remoteMovieService.getMovies(page.getKeyword(),page.getStart(),page.getLength(),flag);

		if(movies == null || movies.size() == 0) return movies;

		List<Type> types = this.typeService.getAllTypes();
		for(Movie movie : movies){
			String movieTypeStr = movie.getType();
			String [] typeStrArr = movieTypeStr.split("_");
			String typeName = "";
			for(String typeStr : typeStrArr){
				for(Type type : types){
					if(type.getId() == Integer.parseInt(typeStr)){
						typeName += type.getType_name() + "/";
					}
				}
			}

			if(!StringUtils.isEmpty(typeName))
				movie.setType(typeName.substring(0, typeName.length()-1));

		}

		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:58:14
	 */
	public int countMovies() {
		try{
			return this.remoteMovieService.countMovies();
		}catch(Exception e){
			System.out.println("countMovie exception");
			e.printStackTrace();
		}

		return 0;

	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:28:07
	 */
	public Movie getOneMovie(int id) {
		try{
			return this.remoteMovieService.getOneMovie(id);
		}catch (Exception e){
			System.out.println("getOneMovie exception");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:18
	 */
	public List<Movie> findPic(Map<String, Object> map) {
		int start = (Integer) map.get("start");
		int length = (Integer) map.get("length");
		try{
			this.remoteMovieService.findPic(start,length);
		}catch(Exception e){
			this.logger.error(e.getMessage(),e);
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:21
	 */
	public boolean modifyPic(String pic, int movieId) {
		return this.remoteMovieService.modifyPic(pic, movieId);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:08:14
	 */
	public boolean deleteMovie(int... movieIds) {
        return this.remoteMovieService.deleteMovie(movieIds);
	}


	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午4:52:32
	 */
	public boolean modifyMoive(Movie movie) {
		return this.remoteMovieService.modifyMoive(movie);
	}
}

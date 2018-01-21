package com.cfw.m1212.web.home.service;

import com.cfw.m1212.model.Movie;
import com.cfw.m1212.model.Type;
import com.cfw.m1212.server.commons.reflect.SimpleAssign;
import com.cfw.m1212.web.commons.dto.Page;
import com.cfw.plugins.mq.rabbitmq.rpc.client.dispatch.OutboundDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("movieService")
@Deprecated
public class MovieService {

    @Autowired
    private TypeService typeService;

    @Autowired
    private OutboundDispatcher outboundDispatcher;

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:36:06
	 */
	public boolean addMovie(Movie movies) {
		/*
		// Persist movie's abstract first.
		boolean addAbstractResult = addDescription(movies.getDescriptions());
		
		// Movie's abstract persist succeed then persist the movie.
		int insertMovieResult = 0;
		if(addAbstractResult){
			insertMovieResult = moviesDaoImpl.insertMovie(movies);
		}
		
		return insertMovieResult>0 ? true : false;*/

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
		List<Movie> movies = null;

		Map<String,Object> paramMap = new HashMap<String,Object>();

		boolean result = SimpleAssign.assignValueToMap(paramMap, page);
        switch(flag){
            case 1:
                //movies = moviesDaoImpl.selectMovies(paramMap);
                break;
            case 2:
                //movies = moviesDaoImpl.selectFullMovies(paramMap);
                break;
        }
		
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
			/*int count = moviesDaoImpl.selectCount();
			return count;*/
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
			/*Movie movie = this.moviesDaoImpl.selectOne(id);
			return movie;*/
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
			//List<Movie> movies = this.moviesDaoImpl.selectPic(start, length);

		}catch(Exception e){
			System.out.println("findPic exception");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:21
	 */
	public boolean modifyPic(Map<String, Object> map) {
		int result =0 ;

		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:08:14
	 */
	public boolean deleteMovie(int... mids) {

		
		return true;
	}


	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午4:52:32
	 */
	public boolean modifyMoive(Movie movie) {
		

		
		return false;
	}
}

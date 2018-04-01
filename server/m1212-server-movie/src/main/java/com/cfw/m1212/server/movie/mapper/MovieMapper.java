package com.cfw.m1212.server.movie.mapper;

import com.cfw.m1212.model.db.Movie;
import com.cfw.m1212.model.db.User;
import com.cfw.plugins.database.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:12:44
 */
@Repository("moviesMapper")
@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
	
	/**
	 * Select movies in list, can be paged.
	 * @param map
	 * @return
	 */
	List<Movie> selectMovies(Map<String, Object> map);

	/**
	 * Select movies with full informations.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午6:13:24
	 * @param map
	 * @return
	 */
	List<Movie> selectFullMovies(Map<String, Object> map);

	/**
	 * Select the count of movies.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:53:52
	 * @return
	 */
	Integer selectCount();

	/**
	 * Delete movies specified by id array.
	 * @author Fangwei_Cai
	 * @time since 2016年4月26日 下午3:03:08
	 * @param ids
	 * @return
	 */
	int deleteMovies(Long[] ids);

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:02:43
	 * @param map
	 * @return
	 */
	List<Movie> selectPic(Map<String, Object> map);

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:02
	 * @return
	 */
	int updatePic(@Param("pic")String pic, @Param("movieId") int movieId);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午6:58:16
	 * @param user
	 * @return
	 */
	List<Movie> selectRecommendedMovies(User user);
	
	/**
	 * Select five movies which score is in top list. 
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:51:40
	 * @return
	 */
	List<Movie> selectTopScoreMoviesToRecommend();
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午5:10:20
	 * @param mid
	 * @return
	 */
	Integer selectDesciptionId(int mid);
}

package com.cfw.m1212.server.movie.dao;

import com.cfw.m1212.model.db.Movie;
import com.cfw.m1212.model.db.User;
import com.cfw.m1212.server.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午4:21:47
 */
@Repository("movieDao")
public class MovieDao {
	
	@Autowired
	private MovieMapper movieMapper;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:25:32
	 */
	public int insertMovie(Movie movies) {
		int result = this.movieMapper.insertOne(movies);
		
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午4:35:59
	 */
	public List<Movie> selectMovies(Map<String, Object> map) {
		List<Movie> movies = this.movieMapper.selectMovies(map);
		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午6:40:04
	 */
	public List<Movie> selectFullMovies(Map<String, Object> map) {
		List<Movie> movies = this.movieMapper.selectFullMovies(map);

		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:56:40
	 */
	public Integer selectCount() {
		return this.movieMapper.selectCount();
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:26:14
	 */
	public Movie selectOne(int id) {
		Movie movie = this.movieMapper.selectOne(id);

		return movie;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:48
	 */
	public List<Movie> selectPic(Map<String, Object> map) {
		List<Movie> movies = this.movieMapper.selectPic(map);

		return movies;
	}

	public List<Movie> selectPic(int start, int length) {
		if( start < 0 || length < 0) return null;
		Map<String,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("length",length);

		return this.selectPic(map);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:53
	 */
	public int updatePic(String pic, int movieId) {
		return this.movieMapper.updatePic(pic,movieId);
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:05:57
	 */
	public int updateMovie(Movie movie) {
		int result = this.movieMapper.updateOne(movie);

		return result;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:44:12
	 */
	public List<Movie> selectRecommendedMovies(User user) {
		List<Movie> recommendMovies = this.movieMapper.selectRecommendedMovies(user);

		return recommendMovies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午8:00:43
	 */
	public List<Movie> selectTopScoreMoviesToRecommend() {
		List<Movie> recommendMovies = this.movieMapper.selectTopScoreMoviesToRecommend();

		return recommendMovies;
	}

	/**
	 * (non-Javadoc)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午5:13:29
	 */
	public Integer selectDesciptionId(int mid) {
		return this.movieMapper.selectDesciptionId(mid);
	}
	
	

}

package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.VideoDAO;
import br.com.earthquake.domain.Video;

@Service("videoService")
public class VideoService {
	
	private VideoDAO videoDAO;
	
	public VideoDAO getVideoDAO() {
		return videoDAO;
	}

	@Autowired
	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}

	public boolean inserirVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Video> carregarVideos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Video> carregarVideosGeracao(Integer geracao) {
		return videoDAO.carregarVideosGeracao(geracao);
	}

	public boolean deletarVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}

}

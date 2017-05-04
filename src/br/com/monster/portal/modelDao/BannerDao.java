package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Banner;

public interface BannerDao extends MetodosBasicos {
	
	List<Banner> Read();
	List<Banner> Read_publico();
	void create(Banner banner);
	void update(Banner banner);

}
package service;

import java.util.List;

import dao.IPLDao;
import entity.Player;

public class IPLService {
	IPLDao dao = new IPLDao();

	public List<Player> getAllPlayersService() {
		return dao.getAllPlayers();
	}

	public Player getPlayerByNameService(String playerName) {
		return dao.getPlayerByName(playerName);
	}

	public void addPlayerService(Player player) {
		dao.addPlayer(player);
	}

	public boolean removePlayerService(int jerseyNumber) {
		return dao.removePlayer(jerseyNumber);
	}

	public List<Player> getBatsmenService() {
		return dao.getBatsmen();
	}

	public List<Player> getBowlersService() {
		return dao.getBowlers();
	}

}

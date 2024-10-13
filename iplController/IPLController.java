package iplController;

import java.util.List;

import entity.Player;
import service.IPLService;

public class IPLController {
	IPLService service = new IPLService();

	public List<Player> getAllPlayersController() {

		return service.getAllPlayersService();

	}

	public Player getPlayerByNameController(String playerName) {
		return service.getPlayerByNameService(playerName);
	}

	public void addPlayerController(Player player) {
		service.addPlayerService(player);
	}

	public boolean removePlayerController(int jerseyNumber) {
		return service.removePlayerService(jerseyNumber);
	}

	public List<Player> getBatsmenController() {
		return service.getBatsmenService();
	}

	public List<Player> getBowlersController() {
		return service.getBowlersService();
	}

}

package client;

import java.util.List;
import java.util.Scanner;

import entity.Player;
import iplController.IPLController;

public class IPLClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPLController C1 = new IPLController();
try {
		do {
			System.out.println("   Welcome to IPL   ");
			System.out.println();
			System.out.println("1. View all Players");
			System.out.println("2. View Player by Name");
			System.out.println("3. Add Player");
			System.out.println("4. Remove Player");
			System.out.println("5. View Batsmens");
			System.out.println("6. View Bowlers");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				List<Player> allPlayers = C1.getAllPlayersController();
				System.out.println("************************************************************");
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", "Jn", "Name", "Runs", "Wickets", "Team");
				System.out.println("************************************************************");
				for (Player player : allPlayers) {
					System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", player.getJn(), player.getName(),
							player.getRuns(), player.getWickets(), player.getTname());
					// System.out.println(p);
					System.out.println("------------------------------------------------------------");
				}
				break;
			case 2:

				System.out.println("Enter player name: ");
				String playerName = sc.nextLine();
				Player playerByName = C1.getPlayerByNameController(playerName);
				if (playerByName != null) {
					System.out.println("-------------------------------------------------------------");
					System.out.println(playerByName);
				} else {
					System.out.println("Player not found.");
				}
				System.out.println("-------------------------------------------------------------");
				break;
			case 3:

				System.out.println("Enter Player Details:");
				System.out.println("Enter Jersey Number: ");
				int jn = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name: ");
				String name = sc.nextLine();
				System.out.println("Enter Runs: ");
				int runs = sc.nextInt();
				System.out.println("Enter Wickets: ");
				int wickets = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Team Name: ");
				String tname = sc.nextLine();

				Player newPlayer = new Player(jn, name, runs, wickets, tname);
				C1.addPlayerController(newPlayer);
				System.out.println("Player added successfully!");
				break;

			case 4:

				System.out.println("Enter the jersey number of the player to remove: ");
				int jerseyNumToRemove = sc.nextInt();
				sc.nextLine();
				boolean removed = C1.removePlayerController(jerseyNumToRemove);
				if (removed) {
					System.out.println("Player removed successfully!");
				} else {
					System.out.println("Player not found.");
				}
				break;

			case 5:

				List<Player> batsmen = C1.getBatsmenController();
				System.out.println("Batsmen:");
				System.out.println("************************************************************");
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", "Jn", "Name", "Runs", "Wickets", "Team");
				System.out.println("************************************************************");
				for (Player batsman : batsmen) {
					System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", batsman.getJn(), batsman.getName(),
							batsman.getRuns(), batsman.getWickets(), batsman.getTname());
					System.out.println("------------------------------------------------------------");
				}
				break;

			case 6:

				List<Player> bowlers = C1.getBowlersController();
				System.out.println("Bowlers:");
				System.out.println("************************************************************");
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", "Jn", "Name", "Runs", "Wickets", "Team");
				System.out.println("************************************************************");
				for (Player bowler : bowlers) {
					System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-5s| \n", bowler.getJn(), bowler.getName(),
							bowler.getRuns(), bowler.getWickets(), bowler.getTname());
					System.out.println("------------------------------------------------------------");
				}
				break;

			case 7:

				System.out.println("Thank You for Using Our Service");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option, Try Again");
			}
		} while (true);
}catch (Exception e) {
	e.printStackTrace();
}
	}
}

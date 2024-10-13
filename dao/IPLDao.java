package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Player;

public class IPLDao {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/batch1199db";
	String unm = "root";
	String pwd = "root";

	Scanner sc = new Scanner(System.in);

	public List<Player> getAllPlayers() {
		List<Player> allPlayers = new ArrayList<Player>();
		// System.out.println("Enter a Query to Execute");
		// String Sql = "Create table sh (id int, primary key(id))";
		String sql2 = "Select * from Player";
		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, unm, pwd);
			// System.out.println("Connection Established");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql2);
			// System.out.println("Result Fetched");

			while (result.next()) {
				int jn = result.getInt("jn");
				String name = result.getString("name");
				int runs = result.getInt("runs");
				int wickets = result.getInt("wickets");
				String tname = result.getString("tname");

				Player p1 = new Player(jn, name, runs, wickets, tname);
				//System.out.println(p1);
				allPlayers.add(p1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return allPlayers;

	}

	public Player getPlayerByName(String playerName) {
		Player player = null;
		String sql = "SELECT * FROM Player WHERE name = ?";
		try (Connection con = DriverManager.getConnection(url, unm, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, playerName);
			try (ResultSet result = pstmt.executeQuery()) {
				if (result.next()) {
					int jn = result.getInt("jn");
					String name = result.getString("name");
					int runs = result.getInt("runs");
					int wickets = result.getInt("wickets");
					String tname = result.getString("tname");
					player = new Player(jn, name, runs, wickets, tname);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}

	public void addPlayer(Player player) {
		String sql = "INSERT INTO Player (jn, name, runs, wickets, tname) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(url, unm, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, player.getJn());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getRuns());
			pstmt.setInt(4, player.getWickets());
			pstmt.setString(5, player.getTname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean removePlayer(int jerseyNumber) {
		String sql = "DELETE FROM Player WHERE jn = ?";
		try (Connection con = DriverManager.getConnection(url, unm, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, jerseyNumber);
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Player> getBatsmen() {
		List<Player> batsmen = new ArrayList<>();
		String sql = "SELECT * FROM Player ORDER BY runs DESC LIMIT 5";
		try (Connection con = DriverManager.getConnection(url, unm, pwd);
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			while (result.next()) {
				int jn = result.getInt("jn");
				String name = result.getString("name");
				int runs = result.getInt("runs");
				int wickets = result.getInt("wickets");
				String tname = result.getString("tname");
				Player p = new Player(jn, name, runs, wickets, tname);
				batsmen.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batsmen;
	}

	public List<Player> getBowlers() {
		List<Player> bowlers = new ArrayList<>();
		String sql = "SELECT * FROM Player ORDER BY wickets DESC LIMIT 5";
		try (Connection con = DriverManager.getConnection(url, unm, pwd);
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			while (result.next()) {
				int jn = result.getInt("jn");
				String name = result.getString("name");
				int runs = result.getInt("runs");
				int wickets = result.getInt("wickets");
				String tname = result.getString("tname");
				Player p = new Player(jn, name, runs, wickets, tname);
				bowlers.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bowlers;
	}

}

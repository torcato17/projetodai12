package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Crianca;

public class SelectCrianca {

	String DRIVER = "com.mysql.jdbc.Driver"; // conecta a base de dados
	String URL = "jdbc:mysql://remotemysql.com:3306"; // diz que o host é o mysql
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "SELECT * FROM  d4YWRRmazE.crianca where id_crianca = ?";
	ResultSet rs;

	Crianca crianca = new Crianca();

	public Crianca retornaCrianca(Crianca cri) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cri.getIdCrianca());
			rs = st.executeQuery();
			rs.next(); // avança no array em ves de criar um vazio

			String nomeCrianca = rs.getString("nome_crianca");
			cri.setNomeCrianca(nomeCrianca);

			Integer idadeCrianca = rs.getInt("idade");
			cri.setIdade(idadeCrianca);

			String concelhoCrianca = rs.getString("concelho");
			cri.setConcelho(concelhoCrianca);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cri;

	}
}

package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import models.Atividade;

public class SelectAtividade {

	// conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host � o mysql
	String URL = "jdbc:mysql://remotemysql.com:3306";
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "SELECT * FROM  d4YWRRmazE.atividade where id_atividade = ?";
	ResultSet rs;
	Atividade ativ = new Atividade();

	public Atividade retornaAtividade(Atividade at) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, at.getIdAtividade());
			rs = st.executeQuery();
			// executeUpdate(); se for um update
			rs.next();
			// avan�a no array em ves de criar um vazio

			String atividade = rs.getString("descricao");
			at.setDescricao(atividade);
			String nomeatividade = rs.getString("nome_atividade");
			at.setNomeAtividade(nomeatividade);
			Date dataatividade = rs.getDate("data");
            at.setData(dataatividade);
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return at;
	}

}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Instituicao;

public class SelectInstituicao {

	String DRIVER = "com.mysql.jdbc.Driver"; // conecta a base de dados
	String URL = "jdbc:mysql://remotemysql.com:3306"; // diz que o host é o mysql
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "SELECT * FROM  d4YWRRmazE.instituição where id_instituicao = ?";
	ResultSet rs;

	Instituicao instituicao = new Instituicao();

	public Instituicao retornaInstituicao(Instituicao inst) {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, inst.getIdInstituicao());
			rs = st.executeQuery();
			rs.next();

			String nomeInstituicao = rs.getString("nome_instituicao");
			inst.setNomeInstituicao(nomeInstituicao);

			String concelhoInstituicao = rs.getString("concelho");
			inst.setConcelho(concelhoInstituicao);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inst;

	}
}

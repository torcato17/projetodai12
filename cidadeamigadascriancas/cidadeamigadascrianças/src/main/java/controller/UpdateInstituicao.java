package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Instituicao;

public class UpdateInstituicao {
	// conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "jdbc:mysql://remotemysql.com:3306";
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "UPDATE d4YWRRmazE.instituicao SET nome_instituicao = ? WHERE id_instituicao = ?";
	int i;

	public int atualizarInstituicao(Instituicao inst) {

		String nome_instituicao = inst.getNomeInstituicao();
		int id = inst.getIdInstituicao();

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, nome_instituicao);
			st.setInt(2, id);
			
			
			i = st.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}

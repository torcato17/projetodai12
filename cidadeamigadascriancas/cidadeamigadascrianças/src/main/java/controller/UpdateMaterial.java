package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Material;

public class UpdateMaterial {

	// conecta a base de dados
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "jdbc:mysql://remotemysql.com:3306";
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "UPDATE d4YWRRmazE.instituição SET nome_instituição = ? WHERE id_instituição = ?";
	int i;

	public int atualizarMaterial(Material mat) {

		String conteudo = mat.getConteudo();
		int id = mat.getIdMaterial();

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, conteudo);
			st.setInt(2, id);

			i = st.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
		
	}

}

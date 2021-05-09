package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Crianca;

public class UpdateCrianca {

	//conecta a base de dados
		String DRIVER = "com.mysql.jdbc.Driver";
		// diz que o host é o mysql
		String URL = "jdbc:mysql://remotemysql.com:3306";
		String USER = "d4YWRRmazE";
		String PASSWORD = "0HMMHO3mbT";
		String sql = "UPDATE d4YWRRmazE.crianca SET nome_crianca = ?, concelho_crianca = ? WHERE id_crianca = ?";
		int i;
		
		public int atualizarCrianca(Crianca cri) {
			
			String nome_crianca = cri.getNomeCrianca();
			String concelho = cri.getConcelho();
			int id = cri.getIdCrianca();
			
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, nome_crianca);
				st.setString(2, concelho);
				st.setInt(3, id);
				i = st.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}

}

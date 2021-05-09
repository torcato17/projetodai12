package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Sugestao;

public class SelectSugestao {

	//conecta a base de dados
		String DRIVER = "com.mysql.jdbc.Driver";
		// diz que o host é o mysql
		String URL = "jdbc:mysql://remotemysql.com:3306";
		String USER = "d4YWRRmazE";
		String PASSWORD = "0HMMHO3mbT";
		String sql = "SELECT * FROM  d4YWRRmazE.sugestao where id_sugestao = ?"; 
		ResultSet rs;
	
		
		Sugestao sugestao = new Sugestao();
		
		public Sugestao retornaSugestao (Sugestao su) {
			try {
				Class.forName(DRIVER);
				 Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			        PreparedStatement st = con.prepareStatement(sql);
			        st.setInt(1, su.getIdSugestao());
			        rs = st.executeQuery();
			        //executeUpdate(); se for um update
			        rs.next();
			        //  avança no array em ves de criar um vazio 
			        
			        String textoSugestao = rs.getString("sugestao");
			        su.setSugestao(textoSugestao);
			        
			        Date dataSugestao = rs.getDate("data");
			        su.setData(dataSugestao);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return su;
}
}
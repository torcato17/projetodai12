package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Comentario;

public class InsertComentario {
	
	String DRIVER = "com.mysql.jdbc.Driver";
	// diz que o host é o mysql
	String URL = "jdbc:mysql://remotemysql.com:3306";
	String USER = "d4YWRRmazE";
	String PASSWORD = "0HMMHO3mbT";
	String sql = "INSERT INTO d4YWRRmazE.comentario(comentario, data_comentario, avaliacao, id_atividade, id_crianca) VALUE (?,?,?,?,?)";
	
	Comentario co = new Comentario();
	
	int resposta;
	public int InsertComentario(Comentario comen) {
		
		String comentario = comen.getComentario();
		Date data = comen.getData();
		int avaliacao = comen.getAvaliacao();
		int id_atividade = comen.getId_atividade();
		int id_crianca = comen.getId_crianca();
		
	
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement st = con.prepareStatement(sql);
	        
	        st.setString(1, comentario);
	        st.setDate(2, data);
	        st.setInt(3, avaliacao);
	        st.setInt(4,id_atividade);
	        st.setInt(5,id_crianca);
			        
	        resposta = st.executeUpdate();
	           
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 	
		return resposta;
	}
	
	

}

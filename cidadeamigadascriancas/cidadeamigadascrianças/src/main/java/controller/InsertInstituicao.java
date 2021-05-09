package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Instituicao;

public class InsertInstituicao {

	//conecta a base de dados
			String DRIVER = "com.mysql.jdbc.Driver";
			// diz que o host é o mysql
			String URL = "jdbc:mysql://remotemysql.com:3306";
			String USER = "d4YWRRmazE";
			String PASSWORD = "0HMMHO3mbT";
			String sql = "INSERT INTO d4YWRRmazE.instituicao(nome_instituicao, concelho_instituicao, username, password, email) VALUE (?,?,?,?,?)";
			
			Instituicao inst = new Instituicao();
			
			int resposta;
			public int criarInstituicao(Instituicao inc) {
				
				String nome_instituicao = inc.getNomeInstituicao();
				String concelho = inc.getConcelho();
				String username = inc.getUsername();
				String password = inc.getPassword();
				String email = inc.getEmail();
						
				try {
					Class.forName(DRIVER);
					Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			        PreparedStatement st = con.prepareStatement(sql);
			        
			        st.setString(1, nome_instituicao);
			        st.setString(2, concelho);
			        st.setString(3, username);
			        st.setString(4, password);
			        st.setString(5, email);
			
			        resposta = st.executeUpdate();
			           
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	 
				return resposta;
			}
}

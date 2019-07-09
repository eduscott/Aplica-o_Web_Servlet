import java.util.Calendar;

public class Contato {
    
	private String nome;
	private Calendar dataNasc;
        private String endereco;
	private String email;
     

        public Contato (String nome, String email, String endereco, Calendar dataNasc){
            this.nome = nome;
            this.dataNasc = dataNasc;
            this.endereco = endereco;
            this.email = email;
            
        }
        
	public String getNome() {
		return nome;
	}
        
        public Calendar getDataNasc() {
		return dataNasc;
	}        
        
	public String getEndereco() {
		return endereco;
	}

        public String getEmail() {
		return email;
	}

}

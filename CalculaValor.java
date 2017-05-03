

public class CalculaValor {
	
	private Acesso acesso;
	private int quantidadeHoras; 
	private int quantidadeMinutos;
	private float valorTotalHoras;
	private float valorTotalMinutos;
	private float valorTotal;
	
	public CalculaValor(Acesso acesso, int quantidadeHoras, int quantidadeMinutos,
			float valorTotalHoras, float valorTotalMinutos, float valorTotal) {
		this.acesso = acesso;
		this.quantidadeHoras = quantidadeHoras;
		this.quantidadeMinutos = quantidadeMinutos;
		this.valorTotalHoras = valorTotalHoras;
		this.valorTotalMinutos = valorTotalMinutos;
		this.valorTotal = valorTotal;
	}
	
	public float compute (){
		
		calculaQuantidadeHorasMinutos();
		calculaValorTotal();	
		return calculaValorDiariaTotal();
	}
	
	private void calculaValorTotal(){
		this.valorTotalHoras = this.quantidadeHoras * Acesso.VALOR_HORA;
		this.valorTotalMinutos = (float) (Math.ceil(this.quantidadeMinutos / 15.0) * Acesso.VALOR_FRACAO);
		this.valorTotal = valorTotalHoras + valorTotalMinutos;	
	}
	
	private void calculaQuantidadeHorasMinutos(){
		this.quantidadeHoras = acesso.horaSaida - acesso.horaEntrada; 
		
		if (acesso.horaSaida == acesso.horaEntrada){
			this.quantidadeMinutos = acesso.minutosSaida - acesso.minutosEntrada;
		}
		else if (acesso.horaSaida > acesso.horaEntrada){
			if (acesso.minutosEntrada == acesso.minutosSaida){
				this.quantidadeMinutos = 0;
			}else if(acesso.minutosEntrada > acesso.minutosSaida){
				this.quantidadeMinutos = acesso.minutosSaida - acesso.minutosEntrada;
			}else if(acesso.minutosSaida < acesso.minutosEntrada){
				this.quantidadeMinutos = acesso.minutosSaida + (60 - acesso.minutosEntrada);
				this.quantidadeHoras = acesso.horaSaida - acesso.horaEntrada - 1;
			}
			
		}else {
			this.quantidadeHoras = 0;
			this.quantidadeMinutos = 0;
		}
	}
	
	private float calculaValorDiariaTotal(){
		if (this.quantidadeHoras >=9)
			return Acesso.VALOR_DIARIA;
		else 
			return valorTotal;
	}

}

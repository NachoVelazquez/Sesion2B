package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	
	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float salariobase=0, primas=0, extras=0;
		if(ventasMes<0  || horasExtra <0) {
			return -1;
		}
		if((tipo!=TipoEmpleado.Encargado && tipo!=TipoEmpleado.Vendedor)) {
			return -2;// este caso nunca se va a dar porque pide el enum de este tipo
		}
		//determinacion salario base
		if(tipo==TipoEmpleado.Encargado)
			salariobase=2500;
		else if(tipo==TipoEmpleado.Vendedor)
			salariobase=2000;
		
		//determinacion prima
		if(ventasMes>=1500)
			primas=200;
		else if(ventasMes>=1000)
			primas=100;
		
		//determinacion extras
		extras=horasExtra*30;
		
		return salariobase + primas + extras;
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion=0;
		if(nominaBruta<0) {
			return -1;
		}
		if(nominaBruta>2500)
			retencion=0.18f;
		else if(nominaBruta>2000)
			retencion=0.15f;
		
		return nominaBruta*(1-retencion);
	}
	
}

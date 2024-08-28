package Eccezioni;

public class Main {

	public static void main(String[] args) {

		BotteVino b = null;
		try {
			b = new BotteVino(300, 50);
			System.out.println("Configurazione iniziale");
			System.out.println(b);
			b.versa(251);
			System.out.println("Dopo aver versato del vino nella botte");
			System.out.println(b);
		} catch (QuantitaNegativaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("messaggio errore: " + e.getMessage());
		} catch (CapacitaSuperataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// BotteVino b1 = new BotteVino(-1);
		// BotteVino b2 = new BotteVino(300, 310);
		catch (VersaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// catch unico
		/*		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		// catch con OR
		/*		catch (QuantitaNegativaException |CapacitaSuperataException | VersaException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		// senza dicharare null
		/* try{
		 * 	if(b!=null){
		 * 		b.versa(6);
		 * 		}else{
      				  System.out.println("la botte non e stata creata);}
			} catch (QuantitaEccessivaException e) e mettere tutti i catch
		 * 			
		 */

	}

}

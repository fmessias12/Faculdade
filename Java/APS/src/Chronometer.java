
	public final class Chronometer {

	private static long startValue; private static long stopValue; private static long timeDiff;

	/**

	* Inicia a contagem temporal */

	public static void start() {

	startValue = System.currentTimeMillis(); stopValue = 0;}

	public static void stop() {

	stopValue = System.currentTimeMillis(); timeDiff = stopValue - startValue;

	} /**

	* Retorna o diferenša de tempo medida * @return tempo em milisegundos */

	public static long elapsedTime() { return timeDiff;

	} 
}

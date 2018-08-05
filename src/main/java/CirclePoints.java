/*
	Задача 114: Тетрадь в клеточку
Все мы в школе рисовали в тетрадке в клеточку. На этот раз вы нарисовали круг и вам нужно определить 
кол-во точек с целочисленными координатами, ктр находятся внутри круга, а также точки на окружности круга. 
Центр круга задан целочисленными координатами.
Входные данные: r - радиус круга, где r - целое число от 1 до 10^4.
Вывод: кол-во точек, ктр заданы целочисленными координатами.
Пример: r = 1
Answer = 5
 * */


/*
 * Для нахождения кол-ва точек, центр круга поместим в начало координат и 
 * будем рассматривать только четвертую часть круга ( 0 < x <= r; 0 <= y <= r ).
 * Результатом будет количество точек на четверти круга * 4 + точка (0, 0) 
 */
public class CirclePoints  
{
	protected int radius;
	private static final int LOWER_BOUND = 1;
	private static final int UPPER_BOUND = 10_000;
	
	public CirclePoints(int radius) {
		if (radius < LOWER_BOUND)
			throw new IllegalArgumentException("Radius cann't be lower than " + LOWER_BOUND);
		if (radius > UPPER_BOUND)
			throw new IllegalArgumentException("Radius cann't be greather than " + UPPER_BOUND);
		
		this.radius = radius;
	}
	
	/*
	 *  Способ 1
	 *  Перебор всех целочисленных точек в квадрате ( 0 < x <= r; 0 <= y <= r ) 
	 */
	public int getPointsCount() {		
		int pointsCnt = 0;
		int r2 = radius * radius;
		for (int x = 1; x <= radius; x++) {
			for (int y = 0; y <= radius; y++) {
				if ((x * x + y * y) <= r2) {
					pointsCnt++;
				} 
			}
		}
		pointsCnt = 4 * pointsCnt + 1;
		return pointsCnt;
	}
	
	/*
	 *  Способ 2
	 *  Для каждой точки на оси Оx построим вертикальный отрезок с максимальной целочисленной длинной, который помещается в окружность.
	 *  Количество точек будет равно "сумме длин всех этих отрезков"
	 */
	public int getPointsCount_2() {		
		int pointsCnt = 0;
		int r2 = radius * radius;
		for (int x = 1; x <= radius; x++) {
			pointsCnt += Math.sqrt(r2 - x * x) + 1;
		}
		pointsCnt = 4 * pointsCnt + 1;
		return pointsCnt;
	}	
	
	
    public static void main( String[] args )
    {	
    	int[] radiuses = new int[] {1, 2, 5, 10, 20, 50, 100, 1_000, 10_000};
    	System.out.println("Method 1");
    	for (int radius : radiuses) {
    		CirclePoints cp = new CirclePoints(radius);
            System.out.println(radius + ": " + cp.getPointsCount());
    	}
    	
    	System.out.println("Method 2");
    	for (int radius : radiuses) {
    		CirclePoints cp = new CirclePoints(radius);
            System.out.println(radius + ": " + cp.getPointsCount_2());
    	}    	
    }	
}
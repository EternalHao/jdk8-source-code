package debug.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @date 2020/4/20 - 9:37 下午
 */
public class AnimalCatCarfield {
	public static void main(String[] args) {
		List<Animal> animal= new ArrayList<Animal>() ;
		List<Cat> cat = new ArrayList<Cat> ();
		List<Garfield> garfield = new ArrayList<Garfield>() ;

		animal.add(new Cat());
		garfield.add(new Garfield());

		// 赋值给 任何T及T子类的集合
//		List<? extends Cat>  extendsCatFromAnimal = animal;
		List<? super Cat> superCatFromAnimal = animal;

		List<? extends Cat> extendsCatFromCat = cat;
		List<? super Cat> superCatFromCat = cat ;

		List<? extends Cat> extendsCatFromGarfield = garfield;
//		List<? super Cat> superCatFromGarfield = garfield;

//		extendsCatFromCat.add(new Animal()) ;
//		extendsCatFromCat.add(new Cat());
//		extendsCatFromCat.add(new Garfield());

//		superCatFromCat.add( new Animal());
		superCatFromCat.add(new Cat());
		superCatFromCat.add(new Garfield());

		Object catExtends2 = extendsCatFromCat.get(0);
		Cat catExtendsl = extendsCatFromCat.get(0);
//		Garfield garfieldl = extendsCatFromGarfield.get(0);
	}


}

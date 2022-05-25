//package match3;
import java.util.Random;

public class Tile extends GameObject{
	int type;
	
	public Tile() {
		Random rand = new Random();
		type = rand.nextInt(5); // 이미지 설정ex. 0은 사과~
		//type 0~4 are regular tiles, 5 means already matched tile
		//System.out.println(type);
	}

}

package Algorithm;

public class 바탕화면 {
	
	public static void main(String[] args) {
		
		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		
		question(wallpaper);
	}
	
	static void question(String[] wallpaper) {
		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rdx = 0;
		int rdy = 0;
		for(int i=0; i<wallpaper.length; i++) {
			for(int j=0; j<wallpaper[i].length(); j++) {
				if('#'==wallpaper[i].charAt(j)) {
					if(luy>j) {
						luy=j;
					}
					if(lux>i) {
						lux=i;
					}
					if(rdx<=i) {
						rdx=i+1;
					}
					if(rdy<=j) {
						rdy=j+1;
					}
				}
			}
		}
	}
}

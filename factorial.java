class factorial{
	public static long calculate(int n){
		int f = 1;
		for (int i=1; i<=n; i++){
			f = f*i;
		}
		return f;
	}
}

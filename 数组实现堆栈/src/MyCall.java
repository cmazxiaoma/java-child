class MyCall {
	private int capacity = 100;
	private String[] items;
	private int top = 0;

	public MyCall() {
		this(100);
	}

	public MyCall(int cap) {
		this.capacity = cap;
		items = new String[cap];
	}

	// 入栈
	public void push(String s) {
		top++;
		items[top] = s;
	}

	// 出栈
	public void pop() {
		items[top] = null;
		top--;
	}

	// 清空腿栈
	public void empty() {
		top = 0;
	}

	// 取出最顶端的堆栈的元素
	public String top() {
		return items[top];
	}

	// 获得推栈元素的个数
	public int size() {
		return top;
	}
}

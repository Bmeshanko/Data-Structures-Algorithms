public class DoubleList {
	
	private DoubleNode head;
	private DoubleNode tail;
	private int length;

	public class DoubleNode {
		private int value;
		private DoubleNode next;
		private DoubleNode prev;

		public DoubleNode() {
			this.value = (int) (1 + 30 * Math.random());
		}

		public void setNext(DoubleNode next) {
			this.next = next;
		}

		public void setPrev(DoubleNode prev) {
			this.prev = prev;
		}
	}

	public void generateList(int length) {

		this.length = length;

		for (int i = 0; i < length; i++) {
			DoubleNode newNode = new DoubleNode();
			
			if (this.head == null) {
				this.head = newNode;
			} else {

				DoubleNode traverse = this.head;

				while (traverse != null && traverse.next != null) {
					traverse = traverse.next;
				}

				traverse.next = newNode;
				newNode.prev = traverse;
			}

			if (i == length - 1) {
				this.tail = newNode;
			}
		}
	}

	public String forwardString() {
		DoubleNode traverse = this.head;
		String s = "";
		for (int i = 0; i < this.length; i++) {
			if (i < length - 1) {
				s += traverse.value + " -> ";
			} else {
				s += traverse.value;
			}
			traverse = traverse.next;
		}
		return s;
	}

	public String backwardString() {
		DoubleNode traverse = this.tail;
		String s = "";
		for (int i = 0; i < this.length; i++) {
			if (i < length - 1) {
				s += traverse.value + " -> ";
			} else {
				s += traverse.value;
			}
			traverse = traverse.prev;
		}
		return s;
	}

	public static void main(String[] args) {

		DoubleList list = new DoubleList();

		list.generateList(5);

		String forward = list.forwardString();
		String backward = list.backwardString();

		System.out.println(forward);
		System.out.println(backward);
	}
}

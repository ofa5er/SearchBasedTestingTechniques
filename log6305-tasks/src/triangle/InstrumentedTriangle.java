package triangle;

import java.util.ArrayList;
import java.util.List;

public class InstrumentedTriangle {

	static final int ILLEGAL_ARGUMENTS = -2;

	static final int ILLEGAL = -3;

	static final int SCALENE = 1;

	static final int EQUILATERAL = 2;

	static final int ISOCELES = 3;

	static final int FIRST = 1;

	static final int SECOND = 2;

	static final int THIRD = 3;

	private List<String> outputs = new ArrayList<String>();

	public static void main(java.lang.String[] args) {
		float[] s;
		s = new float[args.length];
		for (int i = 0; i < args.length; i++) {
			s[i] = new java.lang.Float(args[i]);
		}
		System.out.println(new InstrumentedTriangle().getType(s));
	}

	public List<String> getOutputs() {
		return outputs;
	}

	private float getValue(String a_name, float a, int line, int statementNum) {
		addToOutputs("<line id='" + line + "'>" + "<active clause id='"
				+ statementNum + "'>" + "<variable name='" + a_name + "'>#" + a
				+ "</variable></line>");
		return a;
	}

	private void addToOutputs(String Str) {
		outputs.add(Str);
	}

	public int getType(float[] sides) {

		this.outputs.clear();

		int ret = 0;
		float side1 = sides[0];
		float side2 = sides[1];
		float side3 = sides[2];

		if (getValue("sides", sides.length, 34, FIRST) != 3) {
			addToOutputs("<trace>34</trace>");
			ret = ILLEGAL_ARGUMENTS;
		} else {
			addToOutputs("<trace>-34</trace>");
			if (getValue("side1", side1, 37, FIRST) < 0
					|| getValue("side2", side2, 37, FIRST) < 0
					|| getValue("side3", side3, 37, FIRST) < 0) {
				addToOutputs("<trace>37</trace>");
				ret = ILLEGAL_ARGUMENTS;
			} else {
				addToOutputs("<trace>-37</trace>");
				int triang = 0;
				if (getValue("side1", side1, 41, FIRST) == getValue("side2",
						side2, 41, FIRST)) {
					addToOutputs("<trace>41</trace>");
					triang = triang + 1;
				}
				if (getValue("side2", side2, 44, FIRST) == getValue("side3",
						side3, 44, FIRST)) {
					addToOutputs("<trace>44</trace>");
					triang = triang + 2;
				}
				if (getValue("side1", side1, 47, FIRST) == getValue("side3",
						side3, 47, FIRST)) {
					addToOutputs("<trace>47</trace>");
					triang = triang + 3;
				}
				if (getValue("triang", triang, 50, FIRST) == 0) {
					addToOutputs("<trace>50</trace>");
					if (getValue("side1", side1, 51, FIRST)
							+ getValue("side2", side2, 51, FIRST) < getValue(
								"side3", side3, 51, FIRST)
							|| getValue("side2", side2, 51, SECOND)
									+ getValue("side3", side3, 51, SECOND) < getValue(
										"side1", side1, 51, SECOND)
							|| getValue("side1", side1, 51, THIRD)
									+ getValue("side3", side3, 51, THIRD) < getValue(
										"side2", side2, 51, THIRD)) {
						addToOutputs("<trace>51</trace>");
						ret = ILLEGAL;
					} else {
						addToOutputs("<trace>-51</trace>");
						ret = SCALENE;
					}
				} else {
					addToOutputs("<trace>-50</trace>");
					if (getValue("triang", triang, 57, FIRST) > 3) {
						addToOutputs("<trace>57</trace>");
						ret = EQUILATERAL;
					} else {
						addToOutputs("<trace>-57</trace>");
						if (getValue("triang", triang, 60, FIRST) == 1
								&& getValue("side1", side1, 60, FIRST)
										+ getValue("side2", side2, 60, FIRST) > getValue(
											"side3", side3, 60, FIRST)) {
							addToOutputs("<trace>60</trace>");
							ret = ISOCELES;
						} else {
							addToOutputs("<trace>-60</trace>");
							if (getValue("triang", triang, 63, FIRST) == 2
									&& getValue("side2", side2, 63, FIRST)
											+ getValue("side3", side3, 63,
													FIRST) > getValue("side1",
												side1, 63, FIRST)) {
								addToOutputs("<trace>63</trace>");
								ret = ISOCELES;
							} else {
								addToOutputs("<trace>-63</trace>");
								if (getValue("triang", triang, 66, FIRST) == 3
										&& getValue("side1", side1, 66, FIRST)
												+ getValue("side3", side3, 66,
														FIRST) > getValue(
													"side2", side2, 66, FIRST)) {
									addToOutputs("<trace>66</trace>");
									ret = ISOCELES;
								} else {
									addToOutputs("<trace>-66</trace>");
									ret = ILLEGAL;
								}
							}
						}
					}
				}
			}
		}
		return ret;
	}

}

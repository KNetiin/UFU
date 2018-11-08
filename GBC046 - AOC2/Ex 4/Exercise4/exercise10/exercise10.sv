module exercise10 (
		input logic [2:0] SW,
		output logic [7:7] LEDG
);
		mux4  m1 ({(~SW[1]) , SW[1], (~SW[1]), (~SW[1]),SW[2],SW[0]}, LEDG[7]);
endmodule

module mux4(
	input logic [5:0] SW, // SW[5:2] = ENTRADA, SW[1:0] = SELETOR
   output logic [7:7] LEDG);
   always @ ( * )
     case (SW[1:0])
       0: LEDG = SW[2];
       1: LEDG = SW[3];
       2: LEDG = SW[4];
       3: LEDG = SW[5];
     endcase
endmodule
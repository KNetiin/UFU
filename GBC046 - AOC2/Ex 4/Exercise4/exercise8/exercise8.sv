module exercise8(
	input logic [10:0] SW, // SW[10:3] = ENTRADA, SW[2:0] = SELETOR
   output logic [7:7] LEDG);
   always @ ( * )
     case (SW[2:0])
       0: LEDG = SW[3];
       1: LEDG = SW[4];
       2: LEDG = SW[5];
       3: LEDG = SW[6];
       4: LEDG = SW[7];
       5: LEDG = SW[8];
       6: LEDG = SW[9];
       7: LEDG = SW[10];
     endcase
endmodule
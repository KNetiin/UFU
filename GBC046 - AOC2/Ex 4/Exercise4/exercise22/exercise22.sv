module exercise22(
		input logic [2:0] SW,
      output logic [6:0] LEDG);
  always @ (*)
    case (SW)
       0: LEDG = 7'b0000000;
       1: LEDG = 7'b0000001;
       2: LEDG = 7'b0000011;
       3: LEDG = 7'b0000111;
       4: LEDG = 7'b0001111;
       5: LEDG = 7'b0011111;
       6: LEDG = 7'b0111111;
       7: LEDG = 7'b1111111;
    endcase
endmodule
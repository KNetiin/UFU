module exercise26(
	input logic [1:0] SW, //SW[1] = s, SW[0] = r
	output logic [7:6] LEDG // LEDG[7] = Q,  LEDG[6] = ~Q
);
  always @ ( * )
    case (SW)
      2'b01: LEDG = 2'b01;
      2'b10: LEDG = 2'b10;
      2'b11: LEDG = 2'b00;
    endcase
endmodule
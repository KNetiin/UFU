module exercise28(
		input logic [1:0] SW, //SW[1] = clk, SW[0] = d
		output logic [7:7] LEDG //q
);
  wire n1, n2, clk_b;
  assign #1 n1 = SW[1] & SW[0];
  assign  /*#1*/ clk_b = ~SW[1];
  assign #1 n2 = clk_b & LEDG[7];
  assign #1 LEDG[7] = n1 | n2;
endmodule
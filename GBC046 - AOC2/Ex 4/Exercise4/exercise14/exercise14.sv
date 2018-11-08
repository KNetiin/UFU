module exercise14(
		input logic [5:0]  a,
      output logic [63:0] y);
 
	logic[3:0] d0,d1,d2;
  exercise13 dec0(a[1:0], d0);
  exercise13 dec1(a[3:2], d1);
  exercise13 dec2(a[5:4], d2);

  assign y[0] = d0[0] & d1[0] & d2[0];
  assign y[1] = d0[1] & d1[0] & d2[0];
  assign y[2] = d0[2] & d1[0] & d2[0];
  assign y[3] = d0[3] & d1[0] & d2[0];
  assign y[4] = d0[0] & d1[1] & d2[0];
  assign y[5] = d0[1] & d1[1] & d2[0];
  assign y[6] = d0[2] & d1[1] & d2[0];
  assign y[7] = d0[3] & d1[1] & d2[0];
  assign y[8] = d0[0] & d1[2] & d2[0];
  assign y[9] = d0[1] & d1[2] & d2[0];
  assign y[10] = d0[2] & d1[2] & d2[0];
  assign y[11] = d0[3] & d1[2] & d2[0];
  assign y[12] = d0[0] & d1[3] & d2[0];
  assign y[13] = d0[1] & d1[3] & d2[0];
  assign y[14] = d0[2] & d1[3] & d2[0];
  assign y[15] = d0[3] & d1[3] & d2[0];
  assign y[16] = d0[0] & d1[0] & d2[1];
  assign y[17] = d0[1] & d1[0] & d2[1];
  assign y[18] = d0[2] & d1[0] & d2[1];
  assign y[19] = d0[3] & d1[0] & d2[1];
  assign y[20] = d0[0] & d1[1] & d2[1];
  assign y[21] = d0[1] & d1[1] & d2[1];
  assign y[22] = d0[2] & d1[1] & d2[1];
  assign y[23] = d0[3] & d1[1] & d2[1];
  assign y[24] = d0[0] & d1[2] & d2[1];
  assign y[25] = d0[1] & d1[2] & d2[1];
  assign y[26] = d0[2] & d1[2] & d2[1];
  assign y[27] = d0[3] & d1[2] & d2[1];
  assign y[28] = d0[0] & d1[3] & d2[1];
  assign y[29] = d0[1] & d1[3] & d2[1];
  assign y[30] = d0[2] & d1[3] & d2[1];
  assign y[31] = d0[3] & d1[3] & d2[1];
  assign y[32] = d0[0] & d1[0] & d2[2];
  assign y[33] = d0[1] & d1[0] & d2[2];
  assign y[34] = d0[2] & d1[0] & d2[2];
  assign y[35] = d0[3] & d1[0] & d2[2];
  assign y[36] = d0[0] & d1[1] & d2[2];
  assign y[37] = d0[1] & d1[1] & d2[2];
  assign y[38] = d0[2] & d1[1] & d2[2];
  assign y[39] = d0[3] & d1[1] & d2[2];
  assign y[40] = d0[0] & d1[2] & d2[2];
  assign y[41] = d0[1] & d1[2] & d2[2];
  assign y[42] = d0[2] & d1[2] & d2[2];
  assign y[43] = d0[3] & d1[2] & d2[2];
  assign y[44] = d0[0] & d1[3] & d2[2];
  assign y[45] = d0[1] & d1[3] & d2[2];
  assign y[46] = d0[2] & d1[3] & d2[2];
  assign y[47] = d0[3] & d1[3] & d2[2];
  assign y[48] = d0[0] & d1[0] & d2[3];
  assign y[49] = d0[1] & d1[0] & d2[3];
  assign y[50] = d0[2] & d1[0] & d2[3];
  assign y[51] = d0[3] & d1[0] & d2[3];
  assign y[52] = d0[0] & d1[1] & d2[3];
  assign y[53] = d0[1] & d1[1] & d2[3];
  assign y[54] = d0[2] & d1[1] & d2[3];
  assign y[55] = d0[3] & d1[1] & d2[3];
  assign y[56] = d0[0] & d1[2] & d2[3];
  assign y[57] = d0[1] & d1[2] & d2[3];
  assign y[58] = d0[2] & d1[2] & d2[3];
  assign y[59] = d0[3] & d1[2] & d2[3];
  assign y[60] = d0[0] & d1[3] & d2[3];
  assign y[61] = d0[1] & d1[3] & d2[3];
  assign y[62] = d0[2] & d1[3] & d2[3];
  assign y[63] = d0[3] & d1[3] & d2[3];
  endmodule

module exercise13(
		input logic [1:0] SW,
		output logic [7:4] LEDG
);

assign LEDG[7] = SW[1] & SW[0];
assign LEDG[6] = SW[1] & (~SW[0]);
assign LEDG[5] = (~SW[1]) & SW[0];
assign LEDG[4] = (~SW[1]) & (~SW[0]);
endmodule
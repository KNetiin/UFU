module exercise12(
		input logic [7:0] SW, 
      output logic [2:0] LEDG
);

	always @(*)
	casez (SW)
      8'b1???????: LEDG = 3'b111;
      8'b01??????: LEDG = 3'b110;
      8'b001?????: LEDG = 3'b101;
      8'b0001????: LEDG = 3'b100;
      8'b00001???: LEDG = 3'b011;
      8'b000001??: LEDG = 3'b010;
      8'b0000001?: LEDG = 3'b001;
      8'b00000001: LEDG = 3'b000;
      default:     LEDG = 3'b000;
    endcase
endmodule
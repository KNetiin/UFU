module exercise20(
input logic [7:0] SW,
output reg [7:4] LEDG// NONE = LEDG[7], SAIDA = LEDG[6:4]
);
  always @ ( * )
    casez (SW)
       8'b00000000: begin LEDG[6:4] = 3'd0;  LEDG[7] = 1'b1; end
       8'b00000001: begin LEDG[6:4] = 3'd0;  LEDG[7] = 1'b0; end
       8'b0000001?: begin LEDG[6:4] = 3'd1;  LEDG[7] = 1'b0; end
       8'b000001??: begin LEDG[6:4] = 3'd2;  LEDG[7] = 1'b0; end
       8'b00001???: begin LEDG[6:4] = 3'd3;  LEDG[7] = 1'b0; end
       8'b0001????: begin LEDG[6:4] = 3'd4;  LEDG[7] = 1'b0; end
       8'b001?????: begin LEDG[6:4] = 3'd5;  LEDG[7] = 1'b0; end
       8'b01??????: begin LEDG[6:4] = 3'd6;  LEDG[7] = 1'b0; end
       8'b1???????: begin LEDG[6:4] = 3'd7;  LEDG[7] = 1'b0; end
    endcase
endmodule
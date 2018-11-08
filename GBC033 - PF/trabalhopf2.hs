--Nome: Antonio Carlos Neto

------------------------------TRABALHO COM FUNÇÕES DE ALTA ORDEM------------------------------------
import System.IO

type Nome = String
type Preco = Int
type CodBar = Int
type BaseDeDados = [(CodBar,Nome,Preco)]
type ListaDeCodigos = [CodBar]
type Recibo = [(Nome,Preco)]

tamLinha :: Int
tamLinha = 40

nomeSuper :: String
nomeSuper = "Supermercado Tonhao"

listaDeProdutos :: BaseDeDados
listaDeProdutos = [ (1234, "Oleo DoBom, 1l" , 195),
 (4756, "Chocolate Cazzeiro, 250g" , 180),
 (3216, "Arroz DoBom, 5Kg", 213),
 (5823, "Balas Pedregulho, 1Kg" , 379),
 (4719, "Queijo Mineirim, 1Kg" , 449),
 (6832, "Iogurte Maravilha, 1Kg" , 499),
 (1112, "Rapadura QuebraDente, 1Kg", 80),
 (1111, "Sal Donorte, 1Kg", 221),
 (1113, "Cafe DoBom, 1Kg", 285),
 (1115, "Biscoito Bibi, 1Kg", 80),
 (3814, "Sorvete QGelo, 1l", 695)]

compara :: CodBar->(CodBar,Nome,Preco)->Bool
compara x (a,_,_) = if x == a then True else False

pegaTupla :: [(CodBar,Nome,Preco)]->(Nome,Preco)
pegaTupla [(_,x,y)] = (x,y)

formataCentavos :: Preco->String
formataCentavos x = show (div x 100) ++ "." ++ show (x - ((div x 100)*100))

replicate1 :: Int->String->String
replicate1 1 x = x
replicate1 n x = replicate1 (n-1) x ++ x

formataLinha :: (Nome,Preco) -> String 
formataLinha (x,y) = x ++ replicate1 (tamLinha - length x - length (formataCentavos y)) "." ++ formataCentavos y

formataLinhas :: [(Nome,Preco)] -> String
formataLinhas [] = []
formataLinhas (x : y) = formataLinha x ++ "\n" ++ formataLinhas y

geraTotal :: Recibo->Preco
geraTotal x = snd (foldr1 somaSegundo x)

somaSegundo :: (Nome,Preco)->(Nome,Preco)->(Nome,Preco)
somaSegundo (_,x) (_,y) = ("",(x+y))

formataTotal :: Preco -> String
formataTotal n = "Total" ++ replicate1 (tamLinha -6 -length (formataCentavos n)) "." ++ "$" ++ formataCentavos n

formataRecibo :: Recibo -> String
formataRecibo x = "\n" ++ nomeSuper ++ "\n" ++ formataLinhas x ++ formataTotal (geraTotal x) ++ "\n"

geraRecibo :: ListaDeCodigos -> IO()
geraRecibo lc = putStr (formataRecibo( map (pegaTupla(filter (compara lc) listaDeProdutos)) lc))

----------------------------------------FIM TRABALHO COM FUNÇÕES DE ALTA ORDEM-----------------------------------------------------
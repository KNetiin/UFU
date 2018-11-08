{-Relatorio:

Nome: Antonio Carlos Neto
OBS: Existe três implementações nesse arquivo

Trabalho com leitor:
	A ideia  era  implementar  um  supermercado(trabalho  passado)  com  leitor de 
codigos  de  barra,  mas  para  isso  precisamos de um loop que  conseguissemos ler os
codigos,  então  tive  a  ideia de utilizar uma função que  trabalhe com IO() e dentro
dela  fizessemos  um  loop  usando  o let  when,  e sai  do loop quando  digita 0, e a
cada  leitura  do  codigo imprime o elemento e seu preço utilizando o codigo anterior,
com algumas pequenas modificações, porém chegamos em um  problema,  imprimir  o total,
como  nenhum  dado  esta sendo salvo era impossível descobrir o total. A questão agora
era  armazenar  os  preços, a decisão foi usar arquivo, onde armazenamos os codigos de
barra e no final  só chamarmos uma função ja implementada que imprime o total, colocar
os dados não foi o problema, antes de  iniciar  o loop  apagamos  todos  os  dados  do
arquivo para evitar erro, e  depois  usamos  uma  função  que  escreve  no arquivo sem 
apaga-lo, "appendFile", agora  a questão  é ler  os dados  e transformar  em uma lista
de inteiros,  primeiramente tive a ideia de usar tres funçoes, uma que recebe a string
contendo tudo do arquivo(readFile), e transforma na  lista de  inteiros, e depois duas
auxiliares, sem contar com as funções show e read para fazer conversao de inteiro para 
string e vice e versa, usados a todo momento, entao decidi criar uma  função que conta
quantos numeros existe dado uma  posição  da  string  até  encontrar um  espaço(gerado
automaticamente pelo leitor de codigos de barra), essa função é necessária para evitar
erros, como ter um  codigo  de  barra  com  tamanho diferente de 4, depois tenho outra 
função auxiliar que trabalha pegando esses elementos e retornando  uma  string  deles,
e por fim a principal usa a função read  para converter essa  string em numero e volta
um lista  de  codigos  de  barra, problema  resolvido,  agora é só  imprimir  o total.
-}

------------------------------------------TRABALHO NORMAL------------------------------------
import Control.Monad
import System.IO

type Nome = String
type Preco = Int
type CodBar = Int
type BaseDeDados = [(CodBar,Nome,Preco)]
type ListaDeCodigos = [CodBar]
type Recibo = [(Nome,Preco)]

tamAlimentos :: Int
tamAlimentos = 10

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

getTuplas :: (CodBar,Nome,Preco)->CodBar
getTuplas (x,_,_) = x

getTuplas2 :: (CodBar,Nome,Preco)->(Nome,Preco)
getTuplas2 (_,x,y) = (x,y)

getEnesimo :: Int->(CodBar,Nome,Preco)
getEnesimo x = listaDeProdutos !! x

pegaRecibo :: Int->CodBar->(Nome,Preco)
pegaRecibo 0 x = if(getTuplas(getEnesimo 0) == x)
                   then getTuplas2(getEnesimo 0)
                   else ("Produto Inexistente",0)
pegaRecibo n x = if(getTuplas(getEnesimo n) == x)
                   then getTuplas2(getEnesimo n)
                   else pegaRecibo (n-1) x

fazRecibo :: ListaDeCodigos->Recibo
fazRecibo [x] = [pegaRecibo tamAlimentos x]
fazRecibo (x:y) = [pegaRecibo tamAlimentos x] ++ fazRecibo y

formataCentavos :: Preco->String
formataCentavos x = show (div x 100) ++ "." ++ show (x - ((div x 100)*100))

total :: String->IO()
total x = putStr x

replicate1 :: Int->String->String
replicate1 1 x = x
replicate1 n x = replicate1 (n-1) x ++ x

formataLinha :: (Nome,Preco) -> String 
formataLinha (x,y) = x ++ replicate1 (tamLinha - length x - length (formataCentavos y)) "." ++ formataCentavos y
 
formataLinhas :: [(Nome,Preco)] -> String
formataLinhas [] = []
formataLinhas (x : y) = formataLinha x ++ "\n" ++ formataLinhas y

geraTotal :: Recibo->Preco
geraTotal [] = 0
geraTotal (x : y) = geraTotal y + snd x

formataTotal :: Preco -> String
formataTotal n = "Total" ++ replicate1 (tamLinha -6 -length (formataCentavos n)) "." ++ "$" ++ formataCentavos n

formataRecibo :: Recibo -> String
formataRecibo x = "\n" ++ nomeSuper ++ "\n" ++ formataLinhas x ++ formataTotal (geraTotal x) ++ "\n"

geraRecibo :: ListaDeCodigos -> IO()
geraRecibo lc = putStr (formataRecibo( fazRecibo lc))

----------------------------------------FIM TRABALHO NORMAL---------------------------------------------------------------------

---------------------------TRABALHO COM LEITOR (LE OS CODIGOS DE BARRA E DEPOIS IMPRIME O RESULTADO)-------------------------------
{-
import Control.Monad
import System.IO

type Nome = String
type Preco = Int
type CodBar = Int
type BaseDeDados = [(CodBar,Nome,Preco)]
type ListaDeCodigos = [CodBar]
type Recibo = [(Nome,Preco)]

tamAlimentos :: Int
tamAlimentos = 10

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

getTuplas :: (CodBar,Nome,Preco)->CodBar
getTuplas (x,_,_) = x

getTuplas2 :: (CodBar,Nome,Preco)->(Nome,Preco)
getTuplas2 (_,x,y) = (x,y)

getEnesimo :: Int->(CodBar,Nome,Preco)
getEnesimo x = listaDeProdutos !! x

pegaRecibo :: Int->CodBar->(Nome,Preco)
pegaRecibo 0 x = if(getTuplas(getEnesimo 0) == x)
                   then getTuplas2(getEnesimo 0)
                   else ("Produto Inexistente",0)
pegaRecibo n x = if(getTuplas(getEnesimo n) == x)
                   then getTuplas2(getEnesimo n)
                   else pegaRecibo (n-1) x

fazRecibo :: CodBar->(Nome,Preco)
fazRecibo x = pegaRecibo tamAlimentos x

fazRecibo2 :: ListaDeCodigos->Recibo
fazRecibo2 [x] = [pegaRecibo tamAlimentos x]
fazRecibo2 (x:y) = [pegaRecibo tamAlimentos x] ++ fazRecibo2 y

formataCentavos :: Preco->String
formataCentavos x = show (div x 100) ++ "." ++ show (x - ((div x 100)*100))

geraTotal :: Recibo->Preco
geraTotal [] = 0
geraTotal (x : y) = geraTotal y + snd x

replicate1 :: Int->String->String
replicate1 1 x = x
replicate1 n x = replicate1 (n-1) x ++ x

formataLinha :: (Nome,Preco) -> String 
formataLinha (x,y) = x ++ replicate1 (tamLinha - length x - length (formataCentavos y)) "." ++ formataCentavos y
 
formataLinhas :: [(Nome,Preco)] -> String
formataLinhas [] = []
formataLinhas (x : y) = formataLinha x ++ "\n" ++ formataLinhas y

nomeSuperf :: IO()
nomeSuperf = putStr ("\n" ++ nomeSuper ++ "\n")

main = do
   putStrLn "Sistema Inicializado, digite 0 para cancelar"
   nomeSuperf
   writeFile "file.txt" " "
   let loop = do
           name <- getLine
           if name == "0"
              then putStr ""
              else putStrLn (formataLinha (fazRecibo (rInt name)))
           appendFile "file.txt" name
           when (name /= "0") loop
   loop
   contents <- readFile "file.txt"
   putStrLn (formataTotal (geraTotal (fazRecibo2 (listint 0 contents))))
   --putStrLn contents

rInt :: String -> Int
rInt x = read x 

listint :: Int->String->[Int]
listint n x = if (n + 1) >= (length x)
                 then []
                 else if (x !! n) /= ' '
                        then [rInt (listint' n (cont n 0 x) x)] ++ listint (n+(cont n 0 x)) x
                        else listint (n+1) x

cont :: Int->Int->String->Int
cont n c x = if (n + 1) > (length x)
             then c
             else if x !! n == ' '
                    then c
                    else cont (n+1) (c+1) x

listint' :: Int->Int->String->String
listint' n 0 x = ""
listint' n c x = [(x !! n)] ++ listint' (n+1) (c-1) x
  

formataTotal :: Preco -> String
formataTotal n = "Total" ++ replicate1 (tamLinha -6 -length (formataCentavos n)) "." ++ "$" ++ formataCentavos n
-}
------------------------------------------------FIM TRABALHO LEITOR 1-------------------------------------------------------------------

---------------------------------------TRABALHO LEITOR(LE OS CODIGOS DE BARRAS E JA IMPRIME O RESULTADO)--------------------------------
{-
import Control.Monad
import System.IO

type Nome = String
type Preco = Int
type CodBar = Int
type BaseDeDados = [(CodBar,Nome,Preco)]
type ListaDeCodigos = [CodBar]
type Recibo = [(Nome,Preco)]

tamAlimentos :: Int
tamAlimentos = 10

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

getTuplas :: (CodBar,Nome,Preco)->CodBar
getTuplas (x,_,_) = x

getTuplas2 :: (CodBar,Nome,Preco)->(Nome,Preco)
getTuplas2 (_,x,y) = (x,y)

getEnesimo :: Int->(CodBar,Nome,Preco)
getEnesimo x = listaDeProdutos !! x

pegaRecibo :: Int->CodBar->(Nome,Preco)
pegaRecibo 0 x = if(getTuplas(getEnesimo 0) == x)
                   then getTuplas2(getEnesimo 0)
                   else ("Produto Inexistente",0)
pegaRecibo n x = if(getTuplas(getEnesimo n) == x)
                   then getTuplas2(getEnesimo n)
                   else pegaRecibo (n-1) x

fazRecibo :: ListaDeCodigos->Recibo
fazRecibo [x] = [pegaRecibo tamAlimentos x]
fazRecibo (x:y) = [pegaRecibo tamAlimentos x] ++ fazRecibo y

formataCentavos :: Preco->String
formataCentavos x = show (div x 100) ++ "." ++ show (x - ((div x 100)*100))

total :: String->IO()
total x = putStr x

replicate1 :: Int->String->String
replicate1 1 x = x
replicate1 n x = replicate1 (n-1) x ++ x

formataLinha :: (Nome,Preco) -> String 
formataLinha (x,y) = x ++ replicate1 (tamLinha - length x - length (formataCentavos y)) "." ++ formataCentavos y
 
formataLinhas :: [(Nome,Preco)] -> String
formataLinhas [] = []
formataLinhas (x : y) = formataLinha x ++ "\n" ++ formataLinhas y

geraTotal :: Recibo->Preco
geraTotal [] = 0
geraTotal (x : y) = geraTotal y + snd x

formataTotal :: Preco -> String
formataTotal n = "Total" ++ replicate1 (tamLinha -6 -length (formataCentavos n)) "." ++ "$" ++ formataCentavos n

formataRecibo :: Recibo -> String
formataRecibo x = "\n" ++ nomeSuper ++ "\n" ++ formataLinhas x ++ formataTotal (geraTotal x) ++ "\n"

geraRecibo :: ListaDeCodigos -> IO()
geraRecibo lc = putStr (formataRecibo( fazRecibo lc))

main = do
   putStrLn "Sistema Inicializado, digite os CodBar, digite 0 para cancelar"
   writeFile "file1.txt" " "
   let loop = do
           name <- getLine
           if name == "0"
              then putStr ""
              else appendFile "file1.txt" name
           when (name /= "0") loop
   loop
   contents <- readFile "file1.txt"
   putStr (formataRecibo (fazRecibo (listint 0 contents)))

rInt :: String -> Int
rInt x = read x 

listint :: Int->String->[Int]
listint n x = if (n + 1) >= (length x)
                 then []
                 else if (x !! n) /= ' '
                        then [rInt (listint' n (cont n 0 x) x)] ++ listint (n+(cont n 0 x)) x
                        else listint (n+1) x

cont :: Int->Int->String->Int
cont n c x = if (n + 1) > (length x)
             then c
             else if x !! n == ' '
                    then c
                    else cont (n+1) (c+1) x

listint' :: Int->Int->String->String
listint' n 0 x = ""
listint' n c x = [(x !! n)] ++ listint' (n+1) (c-1) x
-}
---------------------------------------------------FIM TRABALHO LEITOR 2------------------------------------------------------
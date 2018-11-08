pkg load image;

#####################CARREGANDO OS DADOS PARA UM VETOR#####################
arq1 = load('arq1.txt');
arq2 = load('arq2.txt');
arq3 = load('arq3.txt');

####################GERANDO OS DADOS PARA UM HISTOGRAMA####################
[y1,x1] = hist(arq1,20);
[y2,x2] = hist(arq2,20);
[y3,x3] = hist(arq3,20);

###########################NORMALIZANDO O EIXO Y###########################
y1 = y1/1000;
y2 = y2/1000;
y3 = y3/1000;

################CALCULANDO A PROBABILIDADE DO N SER > QUE 1################
indices1 = find(arq1 > 1);
m1 = hist(arq1(indices1));
m1 = m1/1000;
p1 = sum(m1);

indices2 = find(arq2 > 1);
m2 = hist(arq2(indices2));
m2 = m2/1000;
p2 = sum(m2);

indices3 = find(arq3 > 1);
m3 = hist(arq3(indices3));
m3 = m3/1000;
p3 = sum(m3);

##########################PLOTANDO OS HISTOGRAMAS##########################
figure;
bar(x1,y1,"hist");
title ('Buffon - Needle = 1','fontsize',40);
xlabel(p1,'fontsize',40);

figure;
bar(x2,y2,"hist");
title ('Buffon - Needle = 2','fontsize',40);
xlabel(p2,'fontsize',40);

figure;
bar(x3,y3,"hist");
title ('Buffon - Needle = 3','fontsize',40);
xlabel(p3,'fontsize',40);


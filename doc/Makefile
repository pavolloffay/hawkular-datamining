# Pavol Loffay
# Alert prediction master thesis Makefile

NAME=thesis
BIB=bibliography
AUXFILES=$(NAME).{pdf,ps,dvi,log,aux,toc,bbl,blg,out} missfont.log

IMG+=inventory architecture

all: convert_images pdf

pdf: $(NAME).tex $(BIB).bib 
	pdflatex $<
	bibtex $(NAME)
	pdflatex $<
	pdflatex $<

convert_images:
	dia -t eps img/src/*.dia -O img/src
	mogrify -format pdf -- img/src/*.{eps,svg}

clean:
	rm -rf $(AUXFILES) img/src/*.{eps,pdf}

.PHONY: pdf


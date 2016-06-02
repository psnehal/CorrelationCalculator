require(gdata)
require(gplots)
require(huge)
require(ppcor)
require(ctc)
if (labeledSamples == "true") {
	dat <- read.table(inputfile, sep = ",", header = TRUE, na.strings = c("NA", ""), check.names = FALSE, as.is = TRUE, row.names = 1)
} else if (rowSamples == "true") {
	dat <- read.table(inputfile, sep = ",", header = TRUE, na.strings = c("NA", ""), check.names = FALSE, as.is = TRUE)
} else {
	dat <- read.table(inputfile, sep = ",", na.strings = c("NA", ""), check.names = FALSE, as.is = TRUE, row.names = 1)
}
if (rowSamples == "true") {
	metab.list <- names(dat)
} else {
	metab.list <- row.names(dat)
}
dat <- as.matrix(dat)
if (rowSamples == "false")
	dat <- t(dat)
for (i in 1 : ncol(dat))
        dat[is.na(dat[, i]), i] <- median(dat[, i], na.rm = TRUE)
if (doTransform == "true")
	dat <- log2(dat)
if (doScaling == "true")
	dat <- scale(dat, center = TRUE, scale = TRUE)
if (exclusionList != "") {
	colIndex = ncol(dat)
	for (metab in rev(metab.list)) {
		pattern <- paste("|", metab, sep = "", collapse = "")
		pattern <- paste(pattern, "|", sep = "", collapse = "")
		if (length(grep(pattern, exclusionList, fixed = TRUE)) > 0) {
			dat <- dat[, -colIndex]
			metab.list <- metab.list[-colIndex]
		}
		colIndex <- colIndex - 1
	}
}
print("2")

pcor.fit <- pcor(dat, method = "pearson")
coeff <- pcor.fit$estimate
pval <- pcor.fit$p.value
qval <- pval
upperTriangle(qval, diag = FALSE) <- p.adjust(upperTriangle(qval, diag = FALSE), method = "BH")
for (i in 1 : ncol(coeff)) {
	coeff[, i] <- signif(coeff[, i], digits = 3)
	pval[, i] <- signif(pval[, i], digits = 3)
	qval[, i] <- signif(qval[, i], digits = 3)
}
resultsfile <- paste(outputdirectory, outputfile, sep = "", collapse = "")
write.table(metab.list, file = resultsfile, row.names = F, col.names = F, sep = ",")
resultsfile <- sub("output.csv", "coeff_output.csv", resultsfile, fixed = TRUE)
write.table(upperTriangle(coeff, diag = FALSE), file = resultsfile, row.names = F, col.names = F, sep = ",")
resultsfile <- sub("coeff_output.csv", "pval_output.csv", resultsfile, fixed = TRUE)
write.table(upperTriangle(pval, diag = FALSE), file = resultsfile, row.names = F, col.names = F, sep = ",")
resultsfile <- sub("pval_output.csv", "qval_output.csv", resultsfile, fixed = TRUE)
write.table(upperTriangle(qval, diag = FALSE), file = resultsfile, row.names = F, col.names = F, sep = ",")

library(fpp)
library(xts)

setwd('/home/pavol/projects/hawkular/hawkular-datamining/R')
source('getBuckets')

df <- getBuckets()


#Moving Averages smoothing - estimating the trend-cycle of past values.
movingAverageSmoothing5 = ma(df$avg, 5)
movingAverageSmoothing10 = ma(df$avg, 10)

# Exponential smoothing
exponentialSmoothing = ses(df, alpha=0.2, initial="simple", h=3)
 
 
#plot
plot(df$start, df$avg, xlab='time', ylab='non Heap', xaxt='n', type='o', col='red', pch=20)

axis(1, df$start, df$times)

 # moving average 
lines(df$start, movingAverageSmoothing5, col='blue')
lines(df$start, movingAverageSmoothing10, col='orange')
#lines(df$start, exponentialSmoothing, col='green')

#legend
#legend("topleft", lty=1, col=c(1, "blue","red","green"),  c("data", expression(alpha == 0.2), expression(alpha == 0.6),  expression(alpha == 0.89)), pch=1)
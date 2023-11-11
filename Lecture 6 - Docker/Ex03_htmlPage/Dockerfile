# Pull Apache httpd image
FROM httpd:latest
# Define maintainer
LABEL maintainer="deArruda Lucas"
# Copy html files to container directory
COPY ./html/ /usr/local/apache2/htdocs/
# Add permission to directory
RUN chmod -R 755 /usr/local/apache2/htdocs/
# Create directory to be mapped
RUN mkdir -p /var/html/
# Map directory 
VOLUME /var/html/
# Add permission to directory
RUN chmod -R 755 /var/html/
# Full Stack Project Basic Example RESTful API Web Application

## Mô tả
Đây là một ứng dụng web full-stack sử dụng **Java** và **JDBC Servlet** cho phần back-end, xây dựng API theo mô hình **RESTful** để tương tác với cơ sở dữ liệu **MySQL**. Phần front-end có thể sử dụng **HTML/CSS/JavaScript** kết nối với API.

- **Backend**: Java, JDBC, Servlet, Maven
- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Database**: MySQL
- **Server**: Tomcat 8.5

## Kiến trúc
Ứng dụng này tuân theo mô hình kiến trúc RESTful API, tách biệt giữa backend (quản lý logic và dữ liệu) và frontend (hiển thị giao diện người dùng).

### Back-End
Back-end sử dụng **Java Servlets** để xây dựng API RESTful:
- **API Endpoints**: Các endpoint RESTful để thực hiện CRUD (Create, Read, Update, Delete) trên cơ sở dữ liệu MySQL.
- **JDBC**: Kết nối và tương tác với cơ sở dữ liệu MySQL thông qua JDBC.
- **Servlet**: Xử lý các yêu cầu HTTP và chuyển đổi chúng thành các thao tác CRUD.
- **Maven**: Quản lý các phụ thuộc và build dự án.

### Front-End
Front-end có thể triển khai bằng:
- **HTML/CSS/JavaScript**: Basic xử lí phân trang html, css, js, bootsrap hệ thống tương tác thông qua API

## Cấu hình môi trường

### Yêu cầu
- **JDK 1.8** hoặc cao hơn
- **Apache Tomcat 8.5**
- **Maven 3.6**
- **MySQL 8.0**

### Cài đặt

1. **Cài đặt JDK**:
   - Tải và cài đặt JDK từ trang chính thức của Oracle: [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Thiết lập biến môi trường `JAVA_HOME` trỏ đến thư mục cài đặt JDK.

2. **Cài đặt Apache Tomcat**:
   - Tải Tomcat 8.5 từ: [https://tomcat.apache.org/download-80.cgi](https://tomcat.apache.org/download-80.cgi).
   - Giải nén Tomcat và thiết lập biến môi trường `CATALINA_HOME` trỏ đến thư mục cài đặt Tomcat.

3. **Cài đặt Maven**:
   - Tải Maven từ: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).
   - Giải nén và thiết lập biến môi trường `M2_HOME` trỏ đến thư mục cài đặt Maven, đồng thời thêm đường dẫn `M2_HOME/bin` vào biến `PATH`.

4. **Cài đặt MySQL**:
   - Tải và cài đặt MySQL từ: [https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/).
   - Tạo một cơ sở dữ liệu và người dùng với quyền truy cập.

## Thiết lập dự án

1. **Clone dự án từ GitHub**:
   ```bash
   git clone <repository-url>
   cd <repository-name>

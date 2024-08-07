����   A �
      java/lang/Object <init> ()V  com.mysql.cj.jdbc.Driver
 
     java/lang/Class forName %(Ljava/lang/String;)Ljava/lang/Class;   java/lang/ClassNotFoundException	      java/lang/System out Ljava/io/PrintStream;
     
getMessage ()Ljava/lang/String;
       java/io/PrintStream println (Ljava/lang/String;)V " java/util/Scanner	  $ % & in Ljava/io/InputStream;
 ! (  ) (Ljava/io/InputStream;)V + 1HospitalManagementSystem/HospitalManagementSystem - $jdbc:mysql://localhost:3306/hospital / root 1 
Basit_2004
 3 4 5 6 7 java/sql/DriverManager getConnection M(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/sql/Connection; 9  HospitalManagementSystem/Patient
 8 ;  < +(Ljava/sql/Connection;Ljava/util/Scanner;)V > HospitalManagementSystem/Doctor
 = @  A (Ljava/sql/Connection;)V C HOSPITAL MANAGEMENT SYSTEM E 1. Add patient G 2. View patients I 3. View Doctors K 4. Book Appointment M 5. Exit O Enter your choice: 
 ! Q R S nextInt ()I
 8 U V  
addPatient
  X  
 8 Z [  viewPatients
 = ] ^  viewDoctors
 * ` a b bookAppointment n(LHospitalManagementSystem/Patient;LHospitalManagementSystem/Doctor;Ljava/sql/Connection;Ljava/util/Scanner;)V d Enter valid choice!! f java/sql/SQLException
 e  i Enter Patient Id:  k Enter Doctor Id:  m $Enter appointment date (YYY-MM-DD: )
 ! o p  next
 8 r s t getPatientById (I)Z
 = v w t getDoctorById
 * y z { checkDoctorAvailability +(ILjava/lang/String;Ljava/sql/Connection;)Z } PINSERT INTO appointments(patient_id, doctor_id, appointment_date)VALUES(?, ?, ?)  � � � � java/sql/Connection prepareStatement 0(Ljava/lang/String;)Ljava/sql/PreparedStatement; � � � � � java/sql/PreparedStatement setInt (II)V � � � � 	setString (ILjava/lang/String;)V � � � S executeUpdate � appointment Booked! � Failed to book appointment!
 e � �  printStackTrace � $Doctor is not available on this date � (Either doctor or patient doesn't exist!! � NSELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ? � � � � executeQuery ()Ljava/sql/ResultSet; � � � p � java/sql/ResultSet ()Z � � � � getInt (I)I url Ljava/lang/String; ConstantValue username password Code LineNumberTable LocalVariableTable this 3LHospitalManagementSystem/HospitalManagementSystem; main ([Ljava/lang/String;)V e "Ljava/lang/ClassNotFoundException; choice I 
connection Ljava/sql/Connection; patient "LHospitalManagementSystem/Patient; doctor !LHospitalManagementSystem/Doctor; Ljava/sql/SQLException; args [Ljava/lang/String; scanner Ljava/util/Scanner; StackMapTable � preparedStatement Ljava/sql/PreparedStatement; rowsAffected appointmentQuery 	patientId doctorId appointmentDate � java/lang/String count 	resultSet Ljava/sql/ResultSet; query 
SourceFile HospitalManagementSystem.java ! *      � �  �    ,  � �  �    .  � �  �    0      �   /     *� �    �        �        � �   	 � �  �  @     �� 	W� L� +� � � !Y� #� 'L,.0� 2M� 8Y,+� :N� =Y,� ?:� B� � D� � F� � H� � J� � L� � N� +� P6�     ]         #   0   =   K   \-� T� � W� 8-� Y� � W� +� \� � W� -,+� _� � W� �� c� ��[M� ,� g� �     	   � � e � � � e  �   � #      	  
      )  3  =  E  M  U  ]  e  m  u  { ! � # � $ � % � ' � ( � ) � + � , � - � 0 � 1 � 2 � 4 � 6 � 9 � : � ; � = �   R  
 
 � �  { g � �  ) � � �  3 � � �  = � � �  � 
 � �    � � �    � � �  �   9 I 
� (  � !  8 =  � b � �   � !  e 	 a b  �  �  
   �� h� -� P6� j� -� P6� l� -� n:*� q� |+� u� s,� x� ]|:,� ~ :� � � � � � � � 6		� � �� � � �� � 
:� �� � �� � � �� �  K � � e  �   b    @  A  B  C  D $ E * F < G G H K J U K _ L i M s N | O � P � R � V � T � U � X � Y � \ � _ �   p  U ? � �  |  � � 	 �  � �  K S � �    � � �     � � �    � � �    � � �   � � �   � � �  * � � �  �   . � � 
 8 =  ! � � �  � B e� 
 	 z {  �  ,     P�N,-� ~ :� � +� � � � :� � � � � 6� ��� 
:� ��   A G e B C G e  �   :    a  c  d  e  f ' g 1 h ; i @ j B l D q G o I p N r �   R  ; 	 � �   8 � �  '  � �  I  � �    P � �     P � �    P � �   M � �  �   " � B  �  � � �  � B e  �    �
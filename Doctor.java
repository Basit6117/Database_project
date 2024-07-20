����   A m
      java/lang/Object <init> ()V	  	 
   HospitalManagementSystem/Doctor 
connection Ljava/sql/Connection;  select * from doctors       java/sql/Connection prepareStatement 0(Ljava/lang/String;)Ljava/sql/PreparedStatement;      java/sql/PreparedStatement executeQuery ()Ljava/sql/ResultSet;	       java/lang/System out Ljava/io/PrintStream; " 	Doctors: 
 $ % & ' ( java/io/PrintStream println (Ljava/lang/String;)V * +|Doctor id  | Name       |Specialization  | , - . / 0 java/sql/ResultSet next ()Z 2 id , 4 5 6 getInt (Ljava/lang/String;)I 8 name , : ; < 	getString &(Ljava/lang/String;)Ljava/lang/String; > specialization @ |%-11s|%-12s|%-16s| 

 B C D E F java/lang/Integer valueOf (I)Ljava/lang/Integer;
 $ H I J printf <(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream; L java/sql/SQLException
 K N O  printStackTrace Q "SELECT * FROM doctors WHERE id = ?  S T U setInt (II)V (Ljava/sql/Connection;)V Code LineNumberTable LocalVariableTable this !LHospitalManagementSystem/Doctor; viewDoctors I Ljava/lang/String; preparedStatement Ljava/sql/PreparedStatement; 	resultSet Ljava/sql/ResultSet; e Ljava/sql/SQLException; query StackMapTable h java/lang/String getDoctorById (I)Z 
SourceFile Doctor.java !              V  W   F     
*� *+� �    X          	  Y       
 Z [     
     \   W  C     wL*� +�  M,�  N� !� #� )� #-� + � C-1� 3 6-7� 9 :-=� 9 :� ?� Y� ASYSYS� GW���� M,� M�   n q K  X   >             %  .  8  B  L  k  n  q  r  v  Y   R  8 3 2 ]  B ) 8 ^  L  > ^   ` _ `   Y a b  r  c d    w Z [    t e ^  f    � % g  ,� HB K  i j  W   �     3PM*� ,�  N-� R -�  :� + � ��N-� M�   ) , K * + , K  X   * 
   !  #  $  %  & ( ' * ) , , - - 1 / Y   >    _ `    a b  -  c d    3 Z [     3 2 ]   0 e ^  f    � * g  ,�    g  K  k    l
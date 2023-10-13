package models

abstract class DiaryModel {
  val selectedDate: String;
  val startTime: String;
  val endTime: String;
  val memo: String;
}
case class Diary(
  val selectedDate: String,
  val startTime: String,
  val endTime: String,
  val memo: String
) extends DiaryModel

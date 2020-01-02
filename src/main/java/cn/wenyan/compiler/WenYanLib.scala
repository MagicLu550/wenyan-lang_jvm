package cn.wenyan.compiler

import java.util.regex.Pattern

object WenYanLib {

  final val NUMBER : String = "number"

  final val ALL : String = "all"

  final val TYPE : String = "type"

  final val DEFINE_VAR : String = "define_var"

  final val VAR_NAME : String = "var_name"

  final val VAR_VALUE : String = "var_value"

  final val VAR_GET_NAME : String = "get_name"

  final val WRITE : String = "write"

  final val SIMPLE_VAR : String = "simple_var"

  final val CHANGE : String = "change"

  final val BEFORE_NAME : String = "before_name"

  final val AFTER_NAME : String = "after_name"

  final val COMMENT : String = "comment"

  final val STRING : String = "string"

  final val HASH : String = "hash"

  final val SPLIT : String = "[。!,！，、]"

  final val STRING_START : String = "「「"

  final val STRING_END : String = "」」"

  final val NEW_START : String = "『"

  final val NEW_END : String = "』"

  final val NAME_START : String = "「"

  final val NAME_END : String = "」"

  final val BIG_THAN : String = "大於"

  final val SMALL_THAN : String = "小於"

  final val NOT : String = "不"

  final val NOT_BIG_THAN : String = NOT+BIG_THAN

  final val NOT_SMALL_THAN : String = NOT+SMALL_THAN

  final val VAL_DEF : String= NAME_START+"[\\s\\S]+"+NAME_END

  final val VAR_NAME_FOR : String = "var_name_for"

  final val FOR : String = "for"

  final val FOR_END : String = "for_end"
  final val TRUE = "陽"

  final val FALSE = "陰"


  val prefixs = Map[Char,Int](
    '十' -> 10,
    '百' -> 100,
    '千' -> 1000,
    '萬' -> 10000,
    '億' -> 100000000
  )
  val numbers = Map[Char,Int](
    '〇' -> 0,
    '零' -> 0,
    '一' -> 1,
    '二' -> 2,
    '两' -> 2,
    '三' -> 3,
    '四' -> 4,
    '五' -> 5,
    '六' -> 6,
    '七' -> 7,
    '八' -> 8,
    '九' -> 9,
  )



  val syntaxs = Map[String,String](
    DEFINE_VAR -> "吾有[一二三四五六七八九十百十千萬億]+[數言爻列物]",
    VAR_NAME -> "曰[\\s\\S]+",
    VAR_VALUE -> ("名之(曰"+VAL_DEF+")+"),
    VAR_GET_NAME -> ("曰"+VAL_DEF),
    WRITE -> "書之",
    SIMPLE_VAR -> "有[數言爻列物][\\s\\S]+",
    CHANGE -> ("昔之"+VAL_DEF+"者"),
    AFTER_NAME -> ("今"+VAL_DEF+"是也"),
    COMMENT -> "[疏注批]曰",
    FOR -> "為是([一二三四五六七八九十百十千萬億]+|「[\\s\\S]+」)遍",
    FOR_END -> "云云"
  )


  val patterns = Map[String,Pattern](
    NUMBER -> Pattern.compile("[一二三四五六七八九十]+"),
    ALL -> Pattern.compile("[\\s\\S]+"),
    TYPE -> Pattern.compile("[數言爻列物]"),
    VAR_GET_NAME -> Pattern.compile(syntaxs(VAR_GET_NAME)),
    BEFORE_NAME -> Pattern.compile(syntaxs(CHANGE)),
    AFTER_NAME -> Pattern.compile(syntaxs(AFTER_NAME)),
    COMMENT -> Pattern.compile("(「「|『)[^(「「|」」|『|』)]+(」」|』)"),
    STRING -> Pattern.compile("(「「|『)[^(「「|」」|『|』)]+(」」|』)"),
    HASH -> Pattern.compile("\\{\\{[0-9]+HASH~\\}\\}"),
    FOR -> Pattern.compile("[一二三四五六七八九十百十千萬億]+"),
    VAR_NAME_FOR -> Pattern.compile(VAL_DEF)
  )


  val bool = Map[String,String](
    FALSE -> "false",
    TRUE -> "true",
    BIG_THAN -> ">",
    SMALL_THAN -> "<",
    NOT -> "=",
    NOT_BIG_THAN -> "<=",
    NOT_SMALL_THAN -> ">="
  )

}

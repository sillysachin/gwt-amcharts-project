package com.amcharts.gen;

import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.squareup.javawriter.JavaWriter;

public class JSONWriter
{
	static List<String> inputs = Arrays
			.asList( new String[]
			{ "AmCharts", "AmCoordinateChart", "MenuItemOutput", "MenuItemStyle", "AmExport", "AmBalloon", "AmRadarChart", "GaugeArrow", "AmXYChart", "AmAngularGauge", "GaugeAxis", "GaugeBand", "GraphDataItem", "SerialDataItem", "ChartCursor", "AmGraph", "AxisBase", "ValueAxis", "CategoryAxis", "AmRectangularChart", "AmLegend", "AmSerialChart", "ChartScrollbar", "Label", "Guide", "Title", "TrendLine" } );

	public static void main( String args[] ) throws IOException
	{
		for ( String input : inputs )
		{
			jsonWriter( input );
		}
	}

	private static void jsonWriter( String input ) throws IOException
	{
		List<JavaClassAttribute> jcaItems = AttributeReader.run( input );
		FileWriter fileWriter = new FileWriter( new File( input + "JSON" + ".java" ) );
		JavaWriter jsoWriter = null;
		String fieldName = null;
		try
		{
			jsoWriter = new JavaWriter( fileWriter );
			jsoWriter
					.emitPackage( "com.amcharts.json" )
					.beginType( input + "JSON", "class", EnumSet.of( PUBLIC, FINAL ), "Is" + input );
			for ( JavaClassAttribute jca : jcaItems )
			{
				jsoWriter
						.emitField( jca.getJavaType(), jca.getFieldName(), EnumSet
								.of( PRIVATE ) );
			}

			for ( JavaClassAttribute jca : jcaItems )
			{
				fieldName = jca.getFieldName();
				if ( jca.getJavaType().equals( "Boolean" ) )
				{
					jsoWriter
							.emitJavadoc( jca.getJavadocComment() )
							.beginMethod( jca.getJavaType(), "is" + StringUtils.capitalize( jca
									.getFieldName() ), EnumSet.of( PUBLIC ) )
							.emitStatement( "return " + jca.getFieldName() )
							.endMethod();
				}
				else
				{
					jsoWriter
							.emitJavadoc( jca.getJavadocComment() )
							.beginMethod( jca.getJavaType(), "get" + StringUtils.capitalize( jca
									.getFieldName() ), EnumSet.of( PUBLIC ) )
							.emitStatement( "return " + jca.getFieldName() )
							.endMethod();
				}
				jsoWriter
						.emitJavadoc( jca.getJavadocComment() )
						.beginMethod( "void", "set" + StringUtils.capitalize( jca
								.getFieldName() ), EnumSet.of( PUBLIC ), jca.getJavaType(), jca
								.getFieldName() )
						.emitStatement( "this." + jca.getFieldName() + "=" + jca.getFieldName() )
						.endMethod();
			}
			jsoWriter.endType();
		}
		catch ( Exception exception )
		{
			System.out.println( "Failed at " + fieldName + " for " + input );
		}
		finally
		{
			jsoWriter.close();
			fileWriter.close();
		}
	}
}
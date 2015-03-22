package com.appbootup.gwt.client.line;

import com.amcharts.api.IsChartCursor;
import com.amcharts.api.IsChartScrollbar;
import com.amcharts.impl.AmChart;
import com.amcharts.impl.AmCharts;
import com.amcharts.impl.AmGraph;
import com.amcharts.impl.AmSerialChart;
import com.amcharts.impl.CategoryAxis;
import com.amcharts.impl.ChartCursor;
import com.amcharts.impl.ChartScrollbar;
import com.amcharts.impl.ValueAxis;
import com.amcharts.impl.event.AmChartEventJSO;
import com.amcharts.impl.event.AmChartListener;
import com.amcharts.impl.event.DataContext;
import com.amcharts.impl.util.LogUtils;
import com.amcharts.impl.wrapper.AbstractChartWrapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class LineChartWithScrollAndZoom extends AbstractChartWrapper
{
	public LineChartWithScrollAndZoom()
	{
	}

	protected void drawChart( final JsArray<JavaScriptObject> chartData )
	{
		final AmSerialChart amSerialChart = AmCharts.AmSerialChart();
		amSerialChart.setTheme( "none" );
		amSerialChart.setPathToImages( AmCharts.JS_AMCHARTS_IMAGES );
		amSerialChart.setDataProvider( chartData );
		amSerialChart.setCategoryField( "date" );

		CategoryAxis categoryAxis = amSerialChart.getCategoryAxis();
		categoryAxis.setParseDates( true );
		categoryAxis.setGridAlpha( 0.15 );
		categoryAxis.setMinorGridEnabled( true );
		categoryAxis.setAxisColor( "#DADADA" );

		ValueAxis valueAxis = AmCharts.ValueAxis();
		valueAxis.setId( "v1" );
		valueAxis.setAxisAlpha( 0.2 );
		amSerialChart.addValueAxis( valueAxis );

		AmGraph amGraph = AmCharts.AmGraph();
		amGraph.setId( "g1" );
		amGraph.setLineThickness( 2 );
		amGraph.setTitle( "red line" );
		amGraph.setNegativeLineColor( "#0352b5" );
		amGraph.setUseLineColorForBulletBorder( true );
		amGraph.setBullet( "round" );
		amGraph.setBulletBorderColor( "#FFFFFF" );
		amGraph.setBulletBorderAlpha( 1 );
		amGraph.setType( "column" );
		amGraph.setLineColor( "#b5030d" );
		amGraph.setValueAxis( "v1" );
		amGraph.setValueField( "visits" );
		amGraph.setBalloonText( "[[category]]<br><b><span style='font-size:14px;'>Visits: [[value]]</span></b>" );
		amGraph.setType( "column" );
		amSerialChart.addGraph( amGraph );

		AmGraph amGraph2 = AmCharts.AmGraph();
		amGraph2.setId( "g2" );
		amGraph2.setLineThickness( 2 );
		amGraph2.setTitle( "blue line" );
		amGraph2.setNegativeLineColor( "#5352b5" );
		amGraph2.setUseLineColorForBulletBorder( true );
		amGraph2.setBullet( "square" );
		amGraph2.setBulletBorderColor( "#FFFFFF" );
		amGraph2.setBulletBorderAlpha( 1 );
		amGraph2.setType( "column" );
		amGraph2.setLineColor( "#55030d" );
		amGraph2.setValueAxis( "v1" );
		amGraph2.setValueField( "revenue" );
		amGraph.setType( "line" );
		amGraph2.setBalloonText( "[[category]]<br><b><span style='font-size:14px;'>Revenue: [[value]]</span></b>" );
		amSerialChart.addGraph( amGraph2 );

		IsChartScrollbar chartScrollbar = new ChartScrollbar();
		chartScrollbar.setScrollbarHeight( 40 );
		chartScrollbar.setColor( "#FFFFFF" );
		chartScrollbar.setAutoGridCount( true );
		chartScrollbar.setGraph( "g1" );
		amSerialChart.addChartScrollbar( chartScrollbar );

		IsChartCursor chartCursor = new ChartCursor();
		chartCursor.setCursorPosition( "mouse" );
		// setValueLineEnabled disables the clickGraphItem !!! 
		//chartCursor.setValueLineEnabled( true );
		chartCursor.setValueLineBalloonEnabled( true );
		chartCursor.setCursorAlpha( 0.1 );
		chartCursor.setFullWidth( true );
		amSerialChart.addChartCursor( chartCursor );

		amSerialChart.setMouseWheelScrollEnabled( true );

		amSerialChart.addListener( "clickGraphItem", new AmChartListener()
		{
			@Override
			public void function( AmChartEventJSO evt )
			{
				LogUtils.log( evt.getGraph().getId() );

				DataContext dataContext = ( DataContext ) evt.getItem()
						.getDataContext();
				JsArray<JavaScriptObject> subSet = dataContext.getSubSet();
				if ( subSet != null && subSet.length() > 0 )
				{
					AmChart amChart = evt.getChart();
					LogUtils.log( amChart );
				}
			}
		} );

		AmChartListener zoomChart = new AmChartListener()
		{
			public void function( AmChartEventJSO event )
			{
				amSerialChart.zoomToIndexes( chartData.length() - 40, chartData
						.length() - 1 );
			}
		};
		amSerialChart.addListener( "rendered", zoomChart );
		zoomChart( chartData, amSerialChart );

		setAmChart( amSerialChart );
		getReadyCallback().onReady();
	}

	private void zoomChart( final JsArray<JavaScriptObject> chartData, final AmSerialChart amSerialChart )
	{
		amSerialChart.zoomToIndexes( chartData.length() - 40, chartData
				.length() - 1 );
	}

	private void setPanSelect( final boolean panFl, final AmSerialChart chart )
	{
		IsChartCursor chartCursor = chart.getChartCursor();

		if ( panFl )
		{
			chartCursor.setPan( true );
		}
		else
		{
			chartCursor.setPan( false );
			chartCursor.setZoomable( true );
		}
		chart.validateNow();
	}

	public final native JsArray<JavaScriptObject> generateChartData()
	/*-{
		var firstDate = new Date();
		var chartData = [];
		for (var i = 0; i < 1500; i++) {
			// we create date objects here. In your data, you can have date strings
			// and then set format of your dates using chart.dataDateFormat property,
			// however when possible, use date objects, as this will speed up chart rendering.
			var newDate = new Date(firstDate);
			newDate.setDate(newDate.getDate() + i);

			var randomval = Math.random();
			var visits = Math.round(randomval * 40);
			var revenue = (visits * 2) + randomval;

			chartData.push({
				date : newDate,
				visits : visits,
				revenue : revenue
			});
		}
		return chartData;
	}-*/;

	public void init()
	{
		drawChart( generateChartData() );
	}
}